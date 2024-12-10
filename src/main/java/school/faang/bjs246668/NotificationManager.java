package school.faang.bjs246668;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || handler == null) {
            throw new IllegalArgumentException("Arguments must be not null !!!");
        }
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Argument bust be not null !!!");
        }
        if (!notifications.containsKey(notification.getType())) {
            throw new IllegalArgumentException("This type is not found !!!");
        }
        notifications.get(notification.getType()).accept(notification);
    }
}
