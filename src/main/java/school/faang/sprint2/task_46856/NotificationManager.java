package school.faang.sprint2.task_46856;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> notifications;

    public NotificationManager() {
        notifications = new HashMap<>();
    }

    public void registerHandler(String messageType, Consumer<Notification> notification) {
        notifications.put(messageType, notification);
    }

    public void sendNotification(Notification notification) {
        if (notifications.containsKey(notification.getType())) {
            notifications.get(notification.getType()).accept(notification);
        } else {
            System.out.println("No notification action found for: " + notification.getType());
        }
    }
}
