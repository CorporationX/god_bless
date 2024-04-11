package MetaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    public static final Map<String, Consumer<Notification>> NOTIFICATIONS = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        if (type != null && handler != null) {
            NOTIFICATIONS.put(type, handler);
        } else {
            throw new IllegalArgumentException("Type or handler is null.");
        }
    }

    public void sendNotification(Notification notification) {
        NOTIFICATIONS.get(notification.getType()).accept(notification);
    }
}
