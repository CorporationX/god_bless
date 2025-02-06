package school.faang.service;

import school.faang.model.Booking;
import school.faang.observer.BookingObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Admin implements BookingObserver {
    private static final Logger logger = LoggerFactory.getLogger(Admin.class);
    private final String name;

    public Admin(String name) {
        this.name = name;
    }

    @Override
    public void update(Booking booking, String status) {
        logger.info("Admin {} notified: Booking {} has been {}", name, booking, status);
    }
}
