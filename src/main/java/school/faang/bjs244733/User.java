package school.faang.bjs244733;

public class User implements BookingObserver {
    @Override
    public void update(Booking booking, Status status) {
        System.out.println("User - There are changes booking: " + booking + ",  status:" + status);
    }
}
