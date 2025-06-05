package school.faang.bjs2_79723_booking_system;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebhookNotificationObserver implements BookingObserver {
    @Override
    public void update(Booking booking, String status) {
        log.info("Sending webhook notifications. Booking: {} , Status: {}", booking, status);
    }
}
