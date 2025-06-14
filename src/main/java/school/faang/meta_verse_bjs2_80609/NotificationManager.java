package school.faang.meta_verse_bjs2_80609;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private Map<NotificationType, Predicate<Notification>> filters = new HashMap<>();
    private Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type != null && handler != null) {
            notifications.put(type, handler);
        } else {
            log.warn("Тип или обработчик не может быть null");
        }
    }

    public void sendNotification(Notification notification) {
        if (isValid(notification)) {
            NotificationType type = notification.getType();
            Consumer<Notification> handler = notifications.get(type);

            if (handler == null) {
                log.warn("Уведомление не может быть null");
            } else {
                handler.accept(notification);
            }
        } else {
            log.warn("Уведомление не валидно");
        }

    }

    private boolean isValid(Notification notification) {
        Predicate<Notification> filter = filters.get(notification.getType());
        if (filter == null) {
            return true;
        }
        return filter.test(notification);
    }

    public void addFilter(NotificationType notificationType, Predicate<Notification> filter) {
        filters.put(notificationType, filter);
    }
}