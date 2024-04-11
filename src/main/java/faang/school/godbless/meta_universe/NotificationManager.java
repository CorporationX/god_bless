package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> handler) {
        if (notificationId == null || notificationId.isEmpty()) {
            throw new IllegalArgumentException("Параметр " + '\"' + "notificationId" + '\"' + " не может быть null или пустым");
        }
        notifications.put(notificationId, handler);
    }

    public void sendNotification(Notification notification) {
        if (!notifications.containsKey(notification.getType())) {
            throw new IllegalArgumentException("Ключа " + '\"' + notification.getType() + '\"' + " не существует.");
        }
        notifications.get(notification.getType()).accept(notification);
    }
}
