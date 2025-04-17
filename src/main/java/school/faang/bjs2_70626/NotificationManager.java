package school.faang.bjs2_70626;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> settings = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        settings.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = settings.get(notification.getNotificationType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            throw new HandlerNotFoundException("Уведомление через %s не реализовано"
                    .formatted(notification.getNotificationType()));
        }
    }
}
