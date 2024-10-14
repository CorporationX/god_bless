package metaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> processedNotifications = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationConsumer) {
        processedNotifications.put(notificationType, notificationConsumer);
    }


    public void sendNotification(Notification notification) {
        processedNotifications.get(notification.getType()).accept(notification);
    }

}
