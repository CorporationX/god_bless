package school.faang.task46593;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<TypeOfNotification, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(TypeOfNotification type, Consumer<Notification> handler) {
        if (type == null) {
            throw new IllegalArgumentException("type is null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("handler is null");
        }

        notifications.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("notification is null");
        }

        TypeOfNotification type = notification.getType();

        if (!notifications.containsKey(type)) {
            throw new IllegalArgumentException("no handler for type " + type.getNotification());
        }

        notifications.get(type).accept(notification);
    }
}
