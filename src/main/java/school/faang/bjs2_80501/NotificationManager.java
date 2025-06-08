package school.faang.bjs2_80501;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationData = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (isInvalidHandler(handler)) {
            System.out.println("Invalid handler");
            return;
        }

        notificationData.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification, Predicate<String> filter) {
        if (isInvalidNotification(notification) || isInvalidPredicate(filter)) {
            System.out.println("Invalid argument");
            return;
        }

        if (!filter.test(notification.getMessage())) {
            System.out.println("This notification cannot be send: unacceptable message");
            return;
        }

        notificationData.getOrDefault(notification.getType(), (param) ->
                System.out.println("This notification type is not exist")).accept(notification);
    }

    private boolean isInvalidType(NotificationType type) {
        return type == null;
    }

    private boolean isInvalidHandler(Consumer<Notification> handler) {
        return handler == null;
    }

    private boolean isInvalidNotification(Notification notification) {
        return isInvalidType(notification.getType()) || notification.getMessage().isBlank();
    }

    private boolean isInvalidPredicate(Predicate<String> filter) {
        return filter == null;
    }

}
