package school.faang.bjs270636;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private Map<Notification.NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(Notification.NotificationType type, Consumer<Notification> handler) {
        this.handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Обработчи не найден");
        }
    }

    public void sendNotificationWithFilter(Notification notification, Predicate<Notification> filter) {
        if (!filter.test(notification)) {
            System.out.println("Сообщение заблокировано");
        } else {
            sendNotification(notification);
        }
    }
}
