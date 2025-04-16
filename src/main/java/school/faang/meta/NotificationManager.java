package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        NotificationType type = notification.getType();
        Consumer<Notification> handler = handlers.get(type);

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.printf("No handler registered for type: %s%n", type);
        }
    }
}