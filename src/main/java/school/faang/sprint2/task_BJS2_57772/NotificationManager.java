package school.faang.sprint2.task_BJS2_57772;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationActions = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        checkNotificationType(type);
        checkConsumer(handler);

        notificationActions.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        checkNotification(notification);

        notificationActions.get(notification.getType()).accept(notification);
    }

    private void checkNotificationType(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("Тип не может быть пустым");
        }
    }

    private void checkConsumer(Consumer<Notification> handler) {
        if (handler == null) {
            throw new IllegalArgumentException("Обработчик не может быть пустым");
        }
    }

    private void checkNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Уведомление не может быть пустым");
        }

        if (!notificationActions.containsKey(notification.getType())) {
            System.out.printf("Такой тип не создан %s\n", notification);
        }
    }
}
