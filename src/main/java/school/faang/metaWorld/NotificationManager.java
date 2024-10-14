package school.faang.metaWorld;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> NOTIFICATIONS_WITH_HANDLERS = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationConsumer) {
        NOTIFICATIONS_WITH_HANDLERS.put(notificationType, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        NOTIFICATIONS_WITH_HANDLERS.get(notification.getType()).accept(notification);
    }
}
