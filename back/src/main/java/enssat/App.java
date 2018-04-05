package enssat;

import enssat.models.Game;
import enssat.models.User;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.CorsHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class App extends AbstractVerticle {

    private Map<UUID, Game> games = new HashMap<>();
    private Map<UUID, User> users = new HashMap<>();
    private SQLClient mySQLClient;
    private SQLConnection sqlConnection;


    private void createTestData() {
        Game game = new Game("Mario", 100);
        games.put(game.getId(), game);
        game = new Game("Space invaders", 10);
        games.put(game.getId(), game);
        game = new Game("Nier", 10);
        games.put(game.getId(), game);
        game = new Game("GT Sport", 10000);
        games.put(game.getId(), game);
    }

    private void getAllGames(RoutingContext context) {
        context.response()
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily(games.values()));
    }

    private void getAllUsers(RoutingContext context){
        context.response()
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily(users.values()));
    }

    private void findGame(RoutingContext context) {
        String id = context.request().getParam("id");
        if (id == null) {
            context.response().setStatusCode(400).end();
        } else {
            Game game = games.get(UUID.fromString(id));
            context.response()
                    .putHeader("content-type", "application-json; charset=utf-8")
                    .end(Json.encodePrettily(game));
        }
    }

    @Override
    public void start(final Future<Void> future) {
        mySQLClient = MySQLClient.createShared(vertx, config().getJsonObject("database"));
        mySQLClient.getConnection(res -> {
            if(res.succeeded()){
                sqlConnection = res.result();
                sqlConnection.query("SELECT * FROM Users",re -> {
                    if(res.succeeded()){
                        ResultSet result = re.result();
                        List<JsonObject> results = result.getRows();
                        User user;
                        for(JsonObject row : results){
                            user = new User(UUID.fromString(row.getString("idUsers")),row.getString("firstname"),row.getString("lastname"),row.getString("mail"));
                            users.put(user.getId(),user);
                            System.out.println(users.get(user.getId()).getFirstname());
                        }
                    }
                    else{
                        System.err.println("Loul");
                    }
                });
            }
            else{
                System.err.println("Failed to connect");
            }
        });
        createTestData();

        Router router = Router.router(vertx);

        router.route().handler(CorsHandler.create("*"));

        router.route("/").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response
                    .putHeader("content-type", "application/json; charset=utf-8")
                    .end(new JsonObject().put("Server", "0.1").toString());
        });

        router.get("/api/games").handler(this::getAllGames);
        router.get("/api/games/:id").handler(this::findGame);
        router.get("/api/users").handler(this::getAllUsers);

        vertx
                .createHttpServer()
                .requestHandler(router::accept)
                .listen(
                        config().getInteger("port", 4000),
                        res -> {
                            if (res.succeeded()) {
                                future.complete();
                            } else {
                                future.fail(res.cause());
                            }
                        });
    }
}
