package exception;

public class UserLoginAlreadyExistException extends Exception {

    // == constructors ==
    public UserLoginAlreadyExistException() {
    }

    public UserLoginAlreadyExistException(String message) {
        super(message);
    }
}
