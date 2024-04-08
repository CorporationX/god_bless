package meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> NOTIFICATIONS = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler){
        NOTIFICATIONS.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        NOTIFICATIONS.get(notification.getType()).accept(notification);
    }
}
