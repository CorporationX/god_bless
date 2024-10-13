package school.faang.metaWorld;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> NOTIFICATIONS = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationConsumer) {
        NOTIFICATIONS.put(notificationType, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        NOTIFICATIONS.get(notification.getType()).accept(notification);
    }
}
