package school.faang.sprint2.task_46817;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> Notifications = new HashMap<>();

    public void registerHandler(String NotificationType, Consumer<Notification> notificationConsumer) {
        Notifications.putIfAbsent(NotificationType, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        Notifications.get(notification.getType()).accept(notification);
    }
}
