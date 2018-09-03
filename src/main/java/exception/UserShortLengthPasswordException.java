package exception;

public class UserShortLengthPasswordException extends Exception {

    // == constructors ==
    public UserShortLengthPasswordException() {
    }

    public UserShortLengthPasswordException(String message) {
        super(message);
    }
}
