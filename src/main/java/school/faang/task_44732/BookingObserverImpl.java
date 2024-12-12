package school.faang.task_44732;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookingObserverImpl implements BookingObserver {
    @Override
    public void update(Booking booking, String status) {
        log.info("Booking Update - ID {}, Room: {}, Status: {}",
                booking.getBookingId(), booking.getRoom().getRoomId(), status);
    }
}
