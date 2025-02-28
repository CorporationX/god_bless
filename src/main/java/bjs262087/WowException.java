package bjs262087;

public class WowException extends RuntimeException {
    public WowException(String message) {
        super(message);
    }

    public WowException(String message, Throwable cause) {
        super(message, cause);
    }
}
