package school.faang.meta_universe.BJS2_57812;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record Notification(NotificationType type, String message) {
    private static final Logger LOGGER = LoggerFactory.getLogger(Notification.class);

    public Notification {
        if (type == null) {
            LOGGER.error("Notification type is null");
            throw new NullPointerException("Notification type cannot be null");
        }
        if (message == null) {
            LOGGER.error("Notification message is null");
            throw new NullPointerException("Notification message cannot be null");
        }
        if (message.isBlank()) {
            LOGGER.error("Notification message is blank");
            throw new IllegalArgumentException("Notification message cannot be blank");
        }

        LOGGER.info("Creating Notification of type {} with message {}", type.name(), message);
    }
}
