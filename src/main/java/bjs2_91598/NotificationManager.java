package bjs2_91598;

import java.util.*;
import java.util.function.*;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final List<Function<Notification, Notification>> modifiers = new ArrayList<>();

    // Регистрация обработчика
    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    // Добавить фильтр
    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }

    // Добавить модификатор
    public void addModifier(Function<Notification, Notification> modifier) {
        modifiers.add(modifier);
    }

    // Отправка уведомления
    public void sendNotification(Notification notification) {
        // фильтры
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                System.out.println("Уведомление отклонено: " + notification.getMessage());
                return;
            }
        }

        // модификаторы
        for (Function<Notification, Notification> modifier : modifiers) {
            notification = modifier.apply(notification);
        }

        // поиск обработчика
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для: " + notification.getType());
        }
    }
}