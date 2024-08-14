package faang.school.godbless.BJS2_21954;

import lombok.NonNull;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> notifications = new HashMap<>();
    private static Map<Predicate<Notification>, Function<Notification, Notification>> notificationFilters = new HashMap<>();

    public static void registerHandler(String notificationType, Consumer<Notification> notifier) {
        if(notificationType == null)
            throw new IllegalArgumentException("Notification type must be filled");

        notifications.put(notificationType, notifier);
    }

    public static void sendNotification(Notification notification) {
        if(notification.getType() == null)
            throw new IllegalArgumentException("Notification type must be filled");

        filterNotification(notification);
        notifications.get(notification.getType()).accept(notification);
    }

    public static void  registerFilter(Predicate<Notification> predicate, Function<Notification, Notification> function){
        notificationFilters.put(predicate, function);
    }

    public static void  filterNotification(Notification notification){
        notificationFilters.forEach((predicate, function) -> {
            if(predicate.test(notification)){
                function.apply(notification);
            }
        });
    }
}
