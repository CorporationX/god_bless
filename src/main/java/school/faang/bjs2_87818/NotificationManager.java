package school.faang.bjs2_87818;

import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final List<Function<Notification, Notification>> correctors = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null) {
            throw new IllegalArgumentException("type is null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("handler is null");
        }
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("notification is null");
        }
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                System.out.println("Заблокировано фильтром");
                return;
            }
        }
        for (Function<Notification, Notification> corrector : correctors) {
            notification = corrector.apply(notification);
            if (notification == null) {
                throw new RuntimeException("Корректор вернул NULL");
            }
        }
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler == null) {
            System.out.println("Нет обработчика для типа " + notification.getType());
            return;
        }
        handler.accept(notification);
    }

    public void addFilter(Predicate<Notification> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("filter is null");
        }
        filters.add(filter);
    }

    public void addCorrector(Function<Notification, Notification> corrector) {
        if (corrector == null) {
            throw new IllegalArgumentException("Не может быть NULL");
        }
        correctors.add(corrector);
    }
}
