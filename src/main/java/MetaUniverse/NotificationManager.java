package MetaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    public static final Map<String, Consumer<Notification>> NOTIFICATIONS = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        if (type == null && handler == null) {
            throw new IllegalArgumentException("Type or handler is null.");
        }
        NOTIFICATIONS.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification.getType() == null || notification.getType().isEmpty()) {
            throw new IllegalArgumentException("Notification cannot be empty or null.");
        }
        NOTIFICATIONS.get(notification.getType()).accept(notification);
    }
}
