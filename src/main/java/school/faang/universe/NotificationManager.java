package school.faang.universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> manager = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        manager.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (!manager.containsKey(notification.getType())) {
            return;
        }
        manager.get(notification.getType()).accept(notification);
    }
}
