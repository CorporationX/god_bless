package Meta;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    @Setter
    private Predicate<Notification> filter = notification ->
            notification.getMessage().contains("Цензура");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {

        if (notification == null) {
            System.out.println("Уведомление не может быть null");
            return;
        }

        if (filter != null && !filter.test(notification)) {
            System.out.println("Нецензурная лексика: " + notification.getMessage());
            return;
        }
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для уведомления" + notification.getType());
        }
    }
}
