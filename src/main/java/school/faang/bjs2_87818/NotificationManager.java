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

        if (!passesFilters(notification)) {
            System.out.println("Заблокировано фильтром");
            return;
        }

        notification = applyCorrectors(notification);

        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler == null) {
            System.out.println("Нет обработчика для типа " + notification.getType());
            return;
        }
        handler.accept(notification);
    }

    private boolean passesFilters(Notification notification) {
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                return false;
            }
        }
        return true;
    }

    private Notification applyCorrectors(Notification notification) {
        for (Function<Notification, Notification> corrector : correctors) {
            notification = corrector.apply(notification);
            if (notification == null) {
                throw new RuntimeException("Корректор вернул NULL");
            }
        }
        return notification;
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
