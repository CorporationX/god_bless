package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Logger logger = LoggerFactory.getLogger(NotificationManager.class);
    private final Map<NotificationType, Consumer<Notification>> notificationMap = new HashMap<>();

    public boolean registerHandler(NotificationType type, Consumer<Notification> handler) {
        validateNotificationType(type);
        validateHandler(handler);
        if (notificationMap.containsKey(type)) {
            logger.error("Handler for notification type {} is already registered.", type);
            return false;
        }
        notificationMap.put(type, handler);
        logger.info("Successfully registered handler for notification type {}.", type);
        return true;
    }

    public boolean sendNotification(Notification notification) {
        validateNotification(notification);
        if (!notificationMap.containsKey(notification.getType())) {
            logger.error("Handler for notification type {} isn't registered.", notification.getType());
            return false;
        }
        Consumer<Notification> notificationConsumer = notificationMap.get(notification.getType());
        notificationConsumer.accept(notification);
        return true;
    }

    private void validateNotification(Notification type) {
        if (type == null) {
            throw new IllegalArgumentException("The Notification can't be null.");
        }
    }

    private void validateNotificationType(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("The NotificationType can't be null.");
        }
    }

    private void validateHandler(Consumer<Notification> handler) {
        if (handler == null) {
            throw new IllegalArgumentException("The handler can't be null.");
        }
    }
}
