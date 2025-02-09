package school.faang.notifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.models.Booking;
import school.faang.interfaces.BookingObserver;

public class AdminNotifier implements BookingObserver {
    private final Logger logger = LoggerFactory.getLogger(AdminNotifier.class);

    @Override
    public void update(Booking booking, String status) {
        logger.info("Administrator notified. Booking {}, status : {}", booking, status);
    }
}
