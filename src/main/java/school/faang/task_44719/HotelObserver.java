package school.faang.task_44719;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HotelObserver implements BookingObserver {

    @Override
    public void update(Booking booking, BookingStatus status) {
        log.info("{} is {} ", booking, status);
    }
}
