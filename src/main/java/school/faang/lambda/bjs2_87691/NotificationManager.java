package school.faang.lambda.bjs2_87691;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.putIfAbsent(type, handler);
    }

    public void sendNotification(@NonNull Notification notification) {
        Consumer<Notification> notificationConsumer = notifications.get(notification.getType());
        if (notificationConsumer != null) {
            notificationConsumer.accept(notification);
        } else {
            System.out.println("No any notifications for type " + notification.getType());
        }
    }

    public void sendNotificationWithFilter(@NonNull Notification notification, Predicate<String> predicate) {
        if (predicate.test(notification.getMessage())) {
            System.out.println("An unacceptable word in message! Please, edit your message");
        } else {
            sendNotification(notification);
        }
    }

    public void sendNotificationWithEditor(@NonNull Notification notification,
                                           Function<Notification, Notification> function) {
        sendNotification(function.apply(notification));
    }
}