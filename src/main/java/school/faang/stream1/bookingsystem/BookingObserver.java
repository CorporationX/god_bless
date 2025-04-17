package school.faang.stream1.bookingsystem;

public interface BookingObserver {
    void update(Booking booking, String status);
}
