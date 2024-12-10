package school.faang.task_46642;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType notificationType, Consumer<Notification> handler) {
        if (notificationType == null || handler == null) {
            throw new IllegalArgumentException("Notification type and handler must not be null");
        }
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null");
        }

        NotificationType type;
        try {
            type = NotificationType.fromString(notification.type());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid notification type: " + notification.type());
            return;
        }

        Consumer<Notification> handler = handlers.get(type);
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Handler for type '" + type.getType() + "' not found.");
        }
    }

    public void addFilter(String keyword, Consumer<Notification> handler) {
        if (keyword == null || handler == null) {
            throw new IllegalArgumentException("Keyword and handler must not be null");
        }
        handlers.put(NotificationType.EMAIL, handler);
    }

    public void processFilters(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null");
        }
        handlers.forEach((key, value) -> value.accept(notification));
    }
}