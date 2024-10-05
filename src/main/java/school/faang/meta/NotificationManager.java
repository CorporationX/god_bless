package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String name, Consumer<Notification> consumer) {
        notifications.put(name, consumer);
    }

    public void sendNotification(Notification notification) {
        notifications.get(notification.getType()).accept(notification);
    }
}