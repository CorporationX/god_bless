package school.faang.meta;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationTypeConsumerMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationTypeConsumerMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (!notificationTypeConsumerMap.containsKey(notification.getType())) {
            throw new IllegalArgumentException("There is no such type of notification");
        }
        notificationTypeConsumerMap.get(notification.getType()).accept(notification);
    }
}
