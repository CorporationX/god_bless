package school.faang.bjs246738;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationServices = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> consumer) {
        if (id.isEmpty()) {
            throw  new IllegalArgumentException("Notification type cannot be null!");
        }
        notificationServices.put(id, consumer);
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
