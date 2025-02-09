package school.faang.notifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.models.Booking;
import school.faang.interfaces.BookingObserver;

public class GuestNotifier implements BookingObserver {
    private final Logger logger = LoggerFactory.getLogger(GuestNotifier.class);

    @Override
    public void update(Booking booking, String status) {
        logger.info("Guest notified. Booking {}, status : {}", booking, status);
    }
}
