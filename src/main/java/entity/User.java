package entity;

public class User {

    // == constants ==
    public static final String USER_SEPARATOR = ",";

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
        return id + USER_SEPARATOR +
                login + USER_SEPARATOR +
                password;
    }
}
