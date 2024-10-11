package ru.kraiush.BJS2_34667;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> consumer) {
        notificationHandlers.put(notificationType, consumer);
    }

    public void sendNotification(Notification notification) {
        if (!notificationHandlers.containsKey(notification.getType())) {
            throw new NoSuchElementException("There is no notification type: " + notification.getType());
        }
        notificationHandlers.get(notification.getType()).accept(notification);
    }
}
