package school.faang.sprint2.task_46817;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationConsumer) {
        notifications.putIfAbsent(notificationType, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        notifications.get(notification.getType()).accept(notification);
    }
}
