package school.faang.metabjs46838;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || handler == null) {
            throw new IllegalArgumentException("Notification type and handler cannot be null");
        }
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            System.out.println("Notification cannot be null");
            return;
        }

        if (notification.getType() == null || notification.getMessage() == null
                || notification.getMessage().isEmpty()) {
            System.out.println("Notification must have a valid type and a non-empty message");
            return;
        }

        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("There is no handler for the notification type: " + notification.getType());
        }
    }
}
