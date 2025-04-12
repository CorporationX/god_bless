package school.faang.booking.observer;

import school.faang.booking.Booking;

public interface BookingObserver {
    void update(Booking booking, String status);
}