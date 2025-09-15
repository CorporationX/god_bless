package school.faang.bjs2_91711;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(@NonNull Notification notification) {
        Consumer<Notification> consumer = notificationHandlers.get(notification.getType());
        consumer.accept(notification);
    }
}
