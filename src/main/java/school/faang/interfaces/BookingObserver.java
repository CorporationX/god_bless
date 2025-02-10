package school.faang.interfaces;

import school.faang.models.Booking;

public interface BookingObserver {
    void update(Booking booking, String status);
}
