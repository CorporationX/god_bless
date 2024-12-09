package school.faang.bjs244740.observers;

import school.faang.bjs244740.Booking;

public class UserObserver implements BookingObserver {

    private String status;

    @Override
    public void update(Booking booking, String status) {
        this.status = status;
        System.out.println("Booking = " + booking + ", status = " + status);
    }

    @Override
    public String getStatus() {
        return status;
    }
}
