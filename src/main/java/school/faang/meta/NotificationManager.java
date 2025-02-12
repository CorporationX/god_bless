package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationsHandler = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationsHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        notificationsHandler.get(notification.getType()).accept(notification);
    }
}
