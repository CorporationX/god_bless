package school.faang.observer;

import school.faang.model.Booking;

public interface BookingObserver {
    void update(Booking booking, String status);
}
