package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String notification, Consumer<Notification> consumer) {
        notificationMap.put(notification, consumer);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        Consumer<Notification> consumer = notificationMap.get(type);
        consumer.accept(notification);
    }
}