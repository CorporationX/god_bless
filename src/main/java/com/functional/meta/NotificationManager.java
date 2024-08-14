package com.functional.meta;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

import java.util.function.Consumer;

@ToString
public class NotificationManager {

    private Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        if (!type.isEmpty() && !type.isBlank()) {
            notificationMap.put(type, consumer);
        }
    }

    public void sendNotification(Notification notification) {
        if (notification != null) {
            notificationMap.get(notification.getType()).accept(notification);
        }
    }
}
