package school.faang.bjs2_79723_booking_system.observer;

import school.faang.bjs2_79723_booking_system.booking.Booking;
import school.faang.bjs2_79723_booking_system.booking.BookingStatus;

public interface BookingObserver {
    void update(Booking booking, BookingStatus status);
}
