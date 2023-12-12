package meta_756;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public static Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notification) {
        notifications.put(type, notification);
    }

    public void sendNotification(Notification notice) {
        Consumer<Notification> consumer = notifications.get(notice.getType());
        consumer.accept(notice);
    }
}