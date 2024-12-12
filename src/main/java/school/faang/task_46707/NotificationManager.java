package school.faang.task_46707;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<NotificationType, Predicate<Notification>> filters = new HashMap<>();

    void registerHandler(NotificationType notificationType, Consumer<Notification> notificationConsumer) {
        if (notificationType == null || notificationConsumer == null) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }
        if (handlers.containsKey(notificationType)) {
            throw new IllegalArgumentException("Такой тип нотификации уже существует!");
        }

        handlers.put(notificationType, notificationConsumer);
    }

    void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }
        if (filterNotification(notification)) {
            System.out.println("Сообщение содержит неприемлемый контент, отправка отклонена!");
            return;
        }

        var consumerNotification = handlers.get(notification.getType());

        if (consumerNotification != null) {
            consumerNotification.accept(notification);
        } else {
            System.out.println("Такого типа нотификации не существует,");
        }
    }

    void registerFilter(NotificationType notificationType, Predicate<Notification> notificationConsumer) {
        if (notificationType == null || notificationConsumer == null) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }
        if (filters.containsKey(notificationType)) {
            throw new IllegalArgumentException("Такой фильтр нотификации уже существует!");
        }

        filters.put(notificationType, notificationConsumer);
    }

    private boolean filterNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }

        var filterNotification = filters.get(notification.getType());

        if (filterNotification != null) {
            return filterNotification.test(notification);
        } else {
            return false;
        }
    }
}
