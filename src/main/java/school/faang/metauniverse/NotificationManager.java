package school.faang.metauniverse;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private static final String NULL_CONSUMER_WARN = "Обработчика для такого типа уведомления нет: ";
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null) {
            log.warn("Тип нотификации не может быть null!");
            return;
        }

        if (handler == null) {
            log.warn("Обработчик не может быть null!");
            return;
        }
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            log.warn(NULL_CONSUMER_WARN, notification.getType());
        }
    }

    public void sendFilteredNotification(Notification notification, Predicate<Notification> filter) {
        if (filter.test(notification)) {
            sendNotification(notification);
        } else {
            System.out.println("Notification blocked due to filter.");
        }
    }
}
