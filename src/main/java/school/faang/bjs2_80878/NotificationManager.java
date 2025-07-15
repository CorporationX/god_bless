package school.faang.bjs2_80878;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> manager = new HashMap<>();
    private List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || handler == null) {
            System.out.println("Нельзя такой создать");
        }
        manager.put(type, handler);
    }

    public void addFilter(Predicate<Notification> filter) {
        if (filter != null) {
            filters.add(filter);
        }
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            System.out.println("Такого нет");
        }

        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                log.warn("Уведомление заблокировано из-за фильтра: {}", notification.getMessage());
                return;
            }
        }
        NotificationType type = notification.getType();
        Consumer<Notification> handler = manager.get(type);

        if (handler == null) {
            log.warn("Уведомлениен не может быть null");
        } else {
            handler.accept(notification);
        }
    }
}
