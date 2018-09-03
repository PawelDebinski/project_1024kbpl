package entity.parser;

import entity.User;

public class UserParser {

    public static User StringToUser(String nextLine) {
        String[] userInfo = nextLine.split(User.USER_SEPARATOR);

        Long id = Long.parseLong(userInfo[0]);
        String login = userInfo[1];
        String password = userInfo[2];

        return new User(id, login, password);
    }
}
