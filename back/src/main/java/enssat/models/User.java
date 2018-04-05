package enssat.models;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;
    private String birthday;
    private String email;

    public User(UUID id,String username, String password, String birthday, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
