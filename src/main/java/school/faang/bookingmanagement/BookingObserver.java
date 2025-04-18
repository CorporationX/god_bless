package school.faang.bookingmanagement;

public interface BookingObserver {
    void update(Booking booking, String status);
}