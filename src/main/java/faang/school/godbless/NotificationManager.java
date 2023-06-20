package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;

class NotificationManager {
    private Map<String, Consumer<Notification>> notificationHandlers;
    private Map<String, Predicate<Notification>> contentFilters;

    public NotificationManager() {
        notificationHandlers = new HashMap<>();
        contentFilters = new HashMap<>();
    }

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        notificationHandlers.put(notificationType, handler);
    }

    public void registerContentFilter(String notificationType, Predicate<Notification> filter) {
        contentFilters.put(notificationType, filter);
    }

    public void sendNotification(Notification notification) {
        String notificationType = notification.getType();

        Consumer<Notification> handler = notificationHandlers.get(notificationType);
        Predicate<Notification> filter = contentFilters.get(notificationType);

        if (handler != null) {
            if (filter == null || filter.test(notification)) {
                handler.accept(notification);
            } else {
                System.out.println("Оповещение имеет неприемлемый контент и данное оповещение не будет отправлено: " + notification.getMessage());
            }
        } else {
            System.out.println("Нет обработчика для типа оповещения: " + notificationType);
        }
    }

}