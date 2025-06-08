package school.faang.bjs2_79738;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleBookingObserver implements BookingObserver {
    @Override
    public void update(Booking booking, String status) {
        log.info("Observer notified: Booking ID {} for Room {} is {}",
                booking.getBookingId(), booking.getRoom().getRoomNumber(), status);
    }
}