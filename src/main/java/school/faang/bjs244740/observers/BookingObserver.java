package school.faang.bjs244740.observers;

import school.faang.bjs244740.Booking;

public interface BookingObserver {

    void update(Booking booking, String status);

    String getStatus();
}
