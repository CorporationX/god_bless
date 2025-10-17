package school.faang.bjs2_85826;

public class Observer implements BookingObserver {
    @Override
    public void update(Booking booking, String status) {
        System.out.printf("There have been changes in room number %x \n" +
                "status changed to %s", booking.getRoom().getRoomNumber(), status);
    }
}
