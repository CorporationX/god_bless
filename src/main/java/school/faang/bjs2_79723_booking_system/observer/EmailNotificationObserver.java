package school.faang.bjs2_79723_booking_system.observer;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_79723_booking_system.booking.Booking;
import school.faang.bjs2_79723_booking_system.booking.BookingStatus;

@Slf4j
public class EmailNotificationObserver implements BookingObserver {
    @Override
    public void update(Booking booking, BookingStatus status) {
        log.info("Sending status update emails. Booking: {} , Status: {}", booking, status);
    }
}
