package school.faang.task_46711;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification can't be null!");
        }
        Consumer<Notification> handler = handlers.get(notification.type());
        handler.accept(notification);
    }
}


