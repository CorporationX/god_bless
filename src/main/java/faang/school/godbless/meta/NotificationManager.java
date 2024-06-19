package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notification) {
        notifications.put(notificationType, notification);

    }

    public void sendNotification(Notification notification) {
        String notificationType = notification.type();
        Consumer<Notification> notificationConsumer = notifications.get(notificationType);
        if (notificationConsumer != null) {
            notificationConsumer.accept(notification);
        } else {
            throw new IllegalArgumentException("Notification type is incorrect" + notification.type());
        }

    }
}
