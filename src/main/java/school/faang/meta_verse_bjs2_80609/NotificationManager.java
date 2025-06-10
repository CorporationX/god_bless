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
    private List<Predicate<Notification>> filters = new ArrayList<>();
    private Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (isValid(notification)) {
            NotificationType type = notification.getType();
            Consumer<Notification> handler = notifications.get(type);

            if (handler != null) {
                handler.accept(notification);
            }
        } else {
            log.warn("Уведомление не валидно");
        }

    }

    private boolean isValid(Notification notification) {
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                return false;
            }
        }
        return true;
    }

    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }
}