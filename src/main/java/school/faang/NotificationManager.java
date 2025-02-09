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
        if (notificationMap.containsKey(type)) {
            logger.info("Handler for notification type {} is already registered.", type);
            return false;
        }
        notificationMap.put(type, handler);
        logger.info("Successfully registered handler for notification type {}.", type);
        return true;
    }

    public boolean sendNotification(Notification notification) {
        if (!notificationMap.containsKey(notification.getType())) {
            logger.info("Handler for notification type {} isn't registered.", notification.getType());
            return false;
        }
        Consumer<Notification> notificationConsumer = notificationMap.get(notification.getType());
        notificationConsumer.accept(notification);
        return true;
    }
}
