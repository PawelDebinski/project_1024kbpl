package exception;

public class UserShortLengthLoginException extends Exception {

    // == constructors ==
    public UserShortLengthLoginException() {
    }

    public UserShortLengthLoginException(String message) {
        super(message);
    }
}
