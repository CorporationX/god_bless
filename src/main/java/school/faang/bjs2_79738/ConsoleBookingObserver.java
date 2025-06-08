package school.faang.bjs2_79738;

public class ConsoleBookingObserver implements BookingObserver {
    @Override
    public void update(Booking booking, String status) {
        System.out.printf("Observer notified: Booking ID %d for Room %d is %s%n",
                booking.getBookingId(), booking.getRoom().getRoomNumber(), status);
    }
}