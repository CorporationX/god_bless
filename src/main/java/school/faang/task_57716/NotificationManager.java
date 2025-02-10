package school.faang.task_57716;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<NotificationType, Consumer<Notification>> notificationConsumers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || handler == null) {
            throw new IllegalArgumentException("Тип не может быть NULL");
        }
        notificationConsumers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Уведомление не может быть NULL");
        }

        if (!notificationConsumers.containsKey(notification.getType())) {
            throw new IllegalArgumentException("Данный тип не создан: " + notification);
        }
        notificationConsumers.get(notification.getType()).accept(notification);
    }
}
