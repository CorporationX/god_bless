package school.faang.bjs244740.observers;

import school.faang.bjs244740.Booking;

public class HotelObserver implements BookingObserver {

    private String status;

    @Override
    public void update(Booking booking, String status) {
        this.status = status;
        System.out.printf("Hotel Booked: %s status: %S%n", booking, status);
    }

    @Override
    public String getStatus() {
        return status;
    }
}
