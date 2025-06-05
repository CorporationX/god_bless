package school.faang.bjs2_79723_booking_system;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailNotificationObserver implements BookingObserver {
    @Override
    public void update(Booking booking, String status) {
        log.info("Sending status update emails. Booking: {} , Status: {}", booking, status);
    }
}
