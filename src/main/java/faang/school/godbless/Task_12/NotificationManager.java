package faang.school.godbless.Task_12;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationTypeAndHandlers = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> handler) {
        notificationTypeAndHandlers.put(type, handler);
    }

    void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationTypeAndHandlers.get(notification.getType());
        handler.accept(notification);
    }
}

