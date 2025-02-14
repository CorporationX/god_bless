package Meta_universe;

import lombok.Getter;

import java.util.logging.Logger;

@Getter
public class Notification {
    private static final Logger logger = Logger.getLogger(Notification.class.getName());
    private final NotificationType type;
    private final String message;

    public Notification(NotificationType type, String message) {
        if (message.trim().isEmpty()) {
            logger.warning("Message is empty for notification type: " + type);
        }
        this.type = type;
        this.message = message;
    }
}
