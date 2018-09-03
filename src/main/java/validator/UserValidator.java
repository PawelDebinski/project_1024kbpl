package validator;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

public class UserValidator {

    // == constants ==
    private final int MIN_LOGIN_LENGTH = 4;
    private final int MIN_PASSWORD_LENGTH = 6;

    // == fields ==
    private static UserValidator instance = null;

    // == constructors ==
    private UserValidator() {
    }

    // == public methods ==
    public static UserValidator getInstance() {
        if(instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException {

        if(isLoginExists(user.getLogin())) {
            throw new UserLoginAlreadyExistException("User with this login already exists");
        }

        if(isLoginLengthEnouth(user.getLogin())) {
            throw new UserShortLengthLoginException("Login is too short");
        }

        if(isPasswordLengthEnough(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is too short");
        }

        return true;
    }

    private boolean isLoginExists(String login) {
        return !login.equals(null);
    }

    private boolean isLoginLengthEnouth(String login) {
        return login.length() >= MIN_LOGIN_LENGTH;
    }

    private boolean isPasswordLengthEnough(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }
}
