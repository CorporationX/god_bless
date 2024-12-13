package ru.maks1979.task_46776;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationCache = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> consumer) {
        notificationCache.put(notificationId, consumer);
    }

    public void sendNotification(Notification notification) {
        notificationCache.get(notification.getType());
    }
}
