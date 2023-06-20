package meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    static Map<String, Consumer<Notification>> notificationMap = new HashMap<>();
    public static void registerHandler(String identifier, Consumer<Notification> consumer) {
        notificationMap.put(identifier, consumer);
    }
    public static void sendNotification(Notification notification) {
        Consumer<Notification> consumer = notificationMap.get(notification.getType());
        consumer.accept(notification);
    }
}

