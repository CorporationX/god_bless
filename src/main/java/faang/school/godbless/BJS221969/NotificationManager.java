package faang.school.godbless.BJS221969;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public static void registerHandler(String notificationType, Consumer<Notification> notifiers) {
        if (notificationType.isEmpty()) {
            throw new IllegalArgumentException("Notification type must be filled");
        }
        notifications.put(notificationType, notifiers);
    }

    public void sendNotification(Notification notification) {
        if (notification.getType().isBlank()) {
            throw new IllegalArgumentException("Notification type must be filled");
        }
        Consumer<Notification> notifiers = notifications.get(notification.getType());
        if (notifiers != null) {
            notifiers.accept(notification);
        } else {
            throw new IllegalArgumentException("Notification for the type " + notification.getType() + " is not registered");
        }
    }
}
