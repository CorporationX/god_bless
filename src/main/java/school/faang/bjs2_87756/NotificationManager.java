package school.faang.bjs2_87756;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null) {
            throw new IllegalArgumentException("Тип уведомления не может быть null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Обработчик не может быть null");
        }
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Оповещение не может быть пустым");
        }

        Consumer<Notification> handler = handlers.get(notification.getType());

        if (handler != null) {
            handler.accept(notification);
            System.out.println("Обработчик " + handler);
        } else {
            System.out.println("Обработчик для данного типа не найден");
        }
    }
}
