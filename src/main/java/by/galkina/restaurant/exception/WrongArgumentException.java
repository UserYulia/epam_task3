package by.galkina.restaurant.exception;

public class WrongArgumentException extends Exception {
    public WrongArgumentException(String message) {
        super(message);
    }

    public WrongArgumentException() {
    }

    public WrongArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongArgumentException(Throwable cause) {
        super(cause);
    }
}
