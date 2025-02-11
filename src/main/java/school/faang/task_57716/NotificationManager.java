package school.faang.task_57716;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationConsumers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        checkType(type);
        checkHandler(handler);
        notificationConsumers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Уведомление не может быть NULL");
        }
        if (!notificationConsumers.containsKey(notification.getType())) {
            throw new IllegalArgumentException("Данный тип не создан: " + notification +
                    " Доступны только: " + Arrays.stream(NotificationType.values()).toList());
        }
        notificationConsumers.get(notification.getType()).accept(notification);
    }

    private void checkType(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("Поле type не может быть NULL");
        }
    }

    private void checkHandler(Consumer<Notification> handler) {
        if (handler == null) {
            throw new IllegalArgumentException("Поле handler не может быть NULL");
        }
    }
}
