package school.faang.task_44719;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserObserver implements BookingObserver {

    @Override
    public void update(Booking booking, BOOKING_STATUS status) {
        log.info("{} is {} ", booking, status);
    }
}