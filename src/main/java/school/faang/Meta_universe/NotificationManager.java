package school.faang.Meta_universe;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationActions = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationActions.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification) {

        validateType(notification.getType());

        Consumer<Notification> handler = notificationActions.get(notification.getType());

        validateHandler(handler);

        handler.accept(notification);

    }

    public void validateHandler(Consumer<Notification> handler) {

        if (handler == null) {
            throw new IllegalArgumentException("Обработчик не может быть пустым!");
        }
    }

    public void validateType(NotificationType type) {

        if (type == null) {
            throw new IllegalArgumentException("Ошибка! Type не может быть равен null!");
        }


    }
}