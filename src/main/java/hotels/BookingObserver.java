package hotels;


public interface BookingObserver {
    void update(Booking booking, String status);
}
