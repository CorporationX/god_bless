package school.faang.exceptions;

public class ObserverValidationError extends RuntimeException {
    public ObserverValidationError(String message) {
        super(message);
    }
}
