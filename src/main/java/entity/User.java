package entity;

public class User {

    // == fields ==
    private Long id;
    private String login;
    private String password;

    // == constructors ==
    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    // == public methods ==
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return id + "," +
                login + "," +
                password;
    }
}
