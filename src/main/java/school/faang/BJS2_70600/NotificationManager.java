package school.faang.BJS2_70600;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        final Consumer<Notification> notificationConsumer = notifications.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
