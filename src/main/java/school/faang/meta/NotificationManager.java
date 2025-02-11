package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> actions = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        checkNotificationType(type);
        checkConsume(handler);
        actions.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> hander = actions.get(notification.getType());
        hander.accept(notification);
    }

    private void checkNotificationType(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("Notification type is null");
        }
    }

    private void checkConsume(Consumer<Notification> handler) {
        if (handler == null) {
            throw new IllegalArgumentException("handler is null");
        }
    }
}
