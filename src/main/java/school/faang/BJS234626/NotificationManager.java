package school.faang.BJS234626;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public static Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String alert, Consumer<Notification> notification) {
        notifications.put(alert, notification);
    }

    public void sendNotification(Notification notification) {
        notifications.get(notification.getType()).accept(notification);
    }
}
