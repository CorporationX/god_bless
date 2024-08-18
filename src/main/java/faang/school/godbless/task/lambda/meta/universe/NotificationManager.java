package faang.school.godbless.task.lambda.meta.universe;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers;
    private final Map<Predicate<Notification>, Function<Notification, Notification>> notificationFilters;

    public void registerHandler(String notificationType, Consumer<Notification> consumer) {
        notificationHandlers.put(notificationType, consumer);
    }

    public void sendNotification(Notification notification) {
        if (!notificationHandlers.containsKey(notification.getType())) {
            System.out.println("Тип уведомления %s не найден".formatted(notification.getType()));
            return;
        }
        doFilter(notification);
        notificationHandlers.get(notification.getType()).accept(notification);
    }

    public void registerNotificationFilter(Predicate<Notification> predicate,
                                           Function<Notification, Notification> function) {
        notificationFilters.put(predicate, function);
    }

    public void doFilter(Notification notification) {
        notificationFilters.entrySet().forEach(entry -> {
            if (entry.getKey().test(notification)) {
                entry.getValue().apply(notification);
            }
        });
    }
}
