package school.faang.task_46677;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        if (type == null) {
            throw new IllegalArgumentException("type is null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("handler is null");
        }
        if (notifications.containsKey(type)) {
            throw new IllegalArgumentException("handler is already exists for type: " + type);
        }
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("notification is null");
        }
        if (!notifications.containsKey(notification.getType())) {
            throw new IllegalArgumentException("no handler for type: " + notification.getType());
        }
        notifications.get(notification.getType()).accept(notification);
    }
}
