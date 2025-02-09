package school.faang.exceptions;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(int bookingId) {
        super("Booking with ID " + bookingId + " was not found.");
    }
}
