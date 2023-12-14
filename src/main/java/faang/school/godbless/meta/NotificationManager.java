package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String string, Consumer<Notification> consumer) {
        notificationMap.put(string, consumer);
    }

    public void sendNotification(Notification notification) {
        String key = notification.getType();
        if (notificationMap.containsKey(key)) {
            Consumer<Notification> consumer = notificationMap.get(key);
            consumer.accept(notification);
        } else {
            throw new IllegalArgumentException("Notification not found");
        }
    }
}