package school.faang.bjs246738;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<Enum<Enums.NotificationType>, Consumer<Notification>> notificationServices = new HashMap<>();

    public void registerHandler(Enum<Enums.NotificationType> type, Consumer<Notification> consumer) {
        if (type == null) {
            throw  new IllegalArgumentException("Notification type cannot be null!");
        }
        if (consumer == null) {
            throw  new IllegalArgumentException("Data consuming operation is null!");
        }
        notificationServices.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notification == null || notification.getType() == null) {
            throw new IllegalArgumentException("Notification or notification type is not set!");
        }
        Consumer<Notification> consumer = notificationServices.get(notification.getType());
        if (consumer == null) {
            throw new IllegalArgumentException("Notification manager is not set for this type!");
        }

        consumer.accept(notification);
    }
}
