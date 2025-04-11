package school.faang.booking;

public interface BookingObserver {
    void update(Booking booking, String status);
}
