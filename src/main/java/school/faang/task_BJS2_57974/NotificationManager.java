package school.faang.task_BJS2_57974;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    //Карта для хранения обработчиков
    Map<NotificationType, Consumer<Notification>> notificationHandler = new HashMap<>();

    //метод для регистрации обработчика
    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandler.put(type, handler);
    }

    //метод для обработки переданного типа сообщения
    public void sendNotification(Notification notification) {
        if (notificationHandler.containsKey(notification.getType())) {
            notificationHandler.get(notification.getType()).accept(notification);
        } else {
            throw new IllegalArgumentException("No handler registered for notification type" + notification.getType());
        }
    }
}