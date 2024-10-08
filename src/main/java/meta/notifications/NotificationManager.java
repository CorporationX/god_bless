package meta.notifications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> explicitContentFilter = new ArrayList<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        if (notificationType == null || notificationType.trim().isEmpty()) {
            throw new IllegalArgumentException("Необходимо ввести тип оповещения");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Необходимо передать обработчик оповещения");
        }
        handlers.putIfAbsent(notificationType, handler);
    }

    public void addContentFilter(Predicate<Notification> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("Пожалуйста, задайте фильтр");
        }
        explicitContentFilter.add(filter);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Необходимо ввести тип оповещения для передачи");
        }

        for (Predicate<Notification> filter : explicitContentFilter) {
            if (!filter.test(notification)) {
                System.out.println("Данное оповещение отклонено из-за политики безопасности");
                return;
            }
        }

        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Запрошенный обработчик не найден: " + notification.getType());
        }
    }
}
