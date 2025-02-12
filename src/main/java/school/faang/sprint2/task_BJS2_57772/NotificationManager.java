package school.faang.sprint2.task_BJS2_57772;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationActions = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        checkNotificationType(type, handler);
        notificationActions.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        checkNotification(notification);
        notificationActions.get(notification.getType()).accept(notification);
    }

    private void checkNotificationType(NotificationType type, Consumer<Notification> handler) {
        if (type == null) {
            throw new IllegalArgumentException("Тип не может быть null");
        }

        if (handler == null) {
            throw new IllegalArgumentException("Обработчик не может быть null");
        }
    }

    private void checkNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Уведомление не может быть null");
        }

        if (!notificationActions.containsKey(notification.getType())) {
            throw new IllegalArgumentException("Такой тип не создан в базе " + notification.getType());
        }
    }
}
