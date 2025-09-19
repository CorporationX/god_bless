package bjs2_91598;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.function.*;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final List<Function<Notification, Notification>> modifiers = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }

    public void addModifier(Function<Notification, Notification> modifier) {
        modifiers.add(modifier);
    }

    public void sendNotification(Notification notification) {
        // фильтры
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                System.out.println("Уведомление отклонено: " + notification.getMessage());
                return;
            }
        }


        for (Function<Notification, Notification> modifier : modifiers) {
            notification = modifier.apply(notification);
        }

        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для: " + notification.getType());
        }
    }
}