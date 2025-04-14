package hotels;

public class AdminNotifier implements BookingObserver {
    @Override
    public void update(Booking booking, String status) {
        System.out.println("Admin Notification: Booking " + booking.getBookingId() + " is " + status);
    }
}

