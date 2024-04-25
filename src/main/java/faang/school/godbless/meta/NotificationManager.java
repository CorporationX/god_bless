package faang.school.godbless.meta;

import java.util.*;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> HANDLERS = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        HANDLERS.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        Consumer<Notification> handler = HANDLERS.get(type);
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler found for notification type: " + type);
        }
    }
}
