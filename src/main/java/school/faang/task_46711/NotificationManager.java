package school.faang.task_46711;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        Objects.requireNonNull(type, "NotificationType can't be null");
        Objects.requireNonNull(handler, "Handler can't be null!");
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Objects.requireNonNull(notification, "Notification can't be null!");
        Consumer<Notification> handler = handlers.get(notification.type());
        if (handler == null) {
            throw new IllegalStateException("No handler found for notification type: " + notification.type());
        }
        handler.accept(notification);
    }
}


