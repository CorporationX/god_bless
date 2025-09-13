package school.faang.bjs2_87681;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@ToString
@Getter
@EqualsAndHashCode
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationTypeConsumerMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationTypeConsumerMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        notificationTypeConsumerMap.getOrDefault(notification.getType(), not -> {
        }).accept(notification);
    }
}
