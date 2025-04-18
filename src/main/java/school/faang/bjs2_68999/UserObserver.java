package school.faang.bjs2_68999;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserObserver implements BookingObserver {
    @Override
    public void update(Booking booking, String status) {
        log.info("Пользователь: Бронь {} была {}", booking.getBookingId(), status);
    }
}
