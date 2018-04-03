package enssat.models;

import java.util.UUID;

public class Game {
    private UUID id;
    private String name;
    private int userCount;

    public Game(String name, int userCount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.userCount = userCount;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
}
