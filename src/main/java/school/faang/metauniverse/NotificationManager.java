package school.faang.metauniverse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationMap = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(NotificationManager.class);

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type != null || handler != null) {
            notificationMap.put(type, handler);
        } else {
            logger.warn("Cannot register handler: type or handler is null.");
        }
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = notificationMap.get(notification.getType());

        if (notificationConsumer != null) {
            notificationConsumer.accept(notification);
        } else {
            logger.warn("Cannot find notificationType {}", notification.getType());
        }
    }
}
