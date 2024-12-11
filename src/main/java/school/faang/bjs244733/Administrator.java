package school.faang.bjs244733;

public class Administrator implements BookingObserver {
    @Override
    public void update(Booking booking, Status status) {
        System.out.println("Administrator - Attention booking: " + booking + ",  status:" + status);
    }
}
