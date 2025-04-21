package school.faang.metaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notifications.get(notification.getType());
        if (handler == null) {
            throw new IllegalArgumentException("Нет такого обработчика");
        }
        handler.accept(notification);
    }
}