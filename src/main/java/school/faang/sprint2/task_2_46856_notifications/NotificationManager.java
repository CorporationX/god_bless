package school.faang.sprint2.task_2_46856_notifications;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> notifications;

    public NotificationManager() {
        notifications = new HashMap<>();
    }

    public void registerHandler(String messageType, Consumer<Notification> notification) {
        if (messageType == null) {
            throw new IllegalArgumentException("Message type cannot be null");
        }
        if (notification == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }
        if (notifications.containsKey(messageType)) {
            throw new IllegalArgumentException("Message type already registered");
        }
        notifications.put(messageType, notification);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }
        if (notifications.containsKey(notification.getType())) {
            notifications.get(notification.getType()).accept(notification);
        } else {
            System.out.println("No notification action found for: " + notification.getType());
        }
    }
}
