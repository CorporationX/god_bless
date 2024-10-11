package metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationKey, Consumer<Notification> notificationAction) {
        notifications.put(notificationKey, notificationAction);
    }

    public void sendNotification(Notification notification) {
        if (!notifications.containsKey(notification.getType())) {
            return;
        }
        notifications.get(notification.getType()).accept(notification);
    }
}
