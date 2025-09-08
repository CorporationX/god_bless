package school.faang.bjs2_87573.exception;

public class NotificationHandlerUpdatingFailedException extends RuntimeException {
    public NotificationHandlerUpdatingFailedException(String message) {
        super(message);
    }

    public NotificationHandlerUpdatingFailedException(String message, RuntimeException e) {
        super(message, e);
    }
}
