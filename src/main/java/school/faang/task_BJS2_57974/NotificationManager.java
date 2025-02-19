package school.faang.task_BJS2_57974;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    //Карта для хранения обработчиков
    private final Map<NotificationType, Consumer<Notification>> notificationHandler = new HashMap<>();
    //Список фильтров
    private final List<Predicate<Notification>> filters = new ArrayList<>();

    //метод для добавления фильтра
    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }

    //Метод для проверки уведомления на соответствие всем фильтрам
    private boolean isValid(Notification notification) {
        return filters.stream().allMatch(notificationPredicate -> notificationPredicate.test(notification));
    }

    //метод для регистрации обработчика
    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandler.put(type, handler);
    }

    //метод для обработки переданного типа сообщения
    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification can not be null.");
        }

        if (isValid((notification))) {
            if (notificationHandler.containsKey(notification.getType())) {
                notificationHandler.get(notification.getType()).accept(notification);
            } else {
                throw new IllegalArgumentException("No handler registered for notification type "
                          + notification.getType());
            }
        } else {
            System.out.println("The notification is blocked by filter.");
        }
    }
}