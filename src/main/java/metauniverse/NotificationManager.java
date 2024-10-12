package metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationHandlersByType = new HashMap<>();

    public void registerHandler(String notificationKey, Consumer<Notification> notificationAction) {
        notificationHandlersByType.put(notificationKey, notificationAction);
    }

    public void sendNotification(Notification notification) {
        if (notificationHandlersByType.get(notification.getType()) == null) {
            return;
        }
        notificationHandlersByType.get(notification.getType()).accept(notification);
    }
}
