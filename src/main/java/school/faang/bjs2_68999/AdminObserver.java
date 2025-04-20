package school.faang.bjs2_68999;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminObserver implements BookingObserver {
    @Override
    public void update(Booking booking, String status) {
        log.info("Админ: Бронь {} была {}", booking.getBookingId(), status);
    }
}
