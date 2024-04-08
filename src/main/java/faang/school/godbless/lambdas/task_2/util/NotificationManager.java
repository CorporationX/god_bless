package faang.school.godbless.lambdas.task_2.util;

import faang.school.godbless.lambdas.task_2.model.Notification;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> storage = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> consumer) {
        storage.put(notificationType, consumer);
    }

    public void sendNotification(Notification notification) {
        storage.get(notification.getType()).accept(notification);
    }
}