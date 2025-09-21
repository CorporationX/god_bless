package school.faang.bjs2_89104;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<Notification.NotificationType, Consumer<Notification>> notificationHandler = new HashMap<>();

    public void registerHandler(Notification.NotificationType type, Consumer<Notification> handler) {
        if (handler != null) {
            notificationHandler.put(type, handler);
        } else {
            System.out.println("Операция не задана");
        }
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationHandler.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.err.println("Ошибка: Нет обработчика для типа уведомления " + notification.getType());
        }
    }
}
