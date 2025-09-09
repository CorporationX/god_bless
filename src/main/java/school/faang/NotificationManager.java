package school.faang;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new EnumMap<>(NotificationType.class);

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }

        if (handler == null) {
            throw new IllegalArgumentException("Handler cannot be null");
        }

        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }

        Consumer<Notification> handler = notificationHandlers.get(notification.getType());

        if (handler == null) {
            throw new IllegalStateException("No handler for type: " + notification.getType());
        }

        handler.accept(notification);
    }


}
