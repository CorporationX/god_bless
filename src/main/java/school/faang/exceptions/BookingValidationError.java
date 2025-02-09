package school.faang.exceptions;

public class BookingValidationError extends RuntimeException {
    public BookingValidationError(String message) {
        super(message);
    }
}
