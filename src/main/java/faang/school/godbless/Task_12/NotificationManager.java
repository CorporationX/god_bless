package faang.school.godbless.Task_12;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationTypeAndHandlers = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> notification) {
        notificationTypeAndHandlers.put(type, notification);
    }

    void sendNotification(Notification notification) {
        Consumer<Notification> consumer = notificationTypeAndHandlers.get(notification.getType());
        consumer.accept(notification);
    }
}
