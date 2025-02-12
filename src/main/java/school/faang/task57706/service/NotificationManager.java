package school.faang.task57706.service;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@NoArgsConstructor
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || handler == null) {
            throw new NullPointerException("Нельзя использовать пустые значения.");
        } else {
            handlers.put(type, handler);
        }
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new NullPointerException("Уведомление не может быть пустым");
        }

        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Обработчик не зарегистрирован для типа уведомления: " +
                    notification.getType() + ". Сообщение: " + notification.getMessage());
        }
    }
}