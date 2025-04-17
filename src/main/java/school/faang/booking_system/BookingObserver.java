package school.faang.booking_system;

public interface BookingObserver {
    void update(Booking booking, String status);
}
