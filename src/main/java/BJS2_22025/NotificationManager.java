package BJS2_22025;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final String ERROR_MESSAGE = "Error! Notification can't be null!";
    private static final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public static void registerHandler(String notificationType, Consumer<Notification> notify) {
        if (notificationType != null && notify != null) {
            notifications.putIfAbsent(notificationType, notify);
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public static void sendNotification(Notification notification) {
        if (notification.getMessage() != null && notification.getType() != null) {
            notifications.get(notification.getType()).accept(notification);
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }
}
