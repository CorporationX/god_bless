package school.faang.second_sprint.googlemaps.meta;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        notificationMap.put(type, handler);

    }

    public void sendNotification(Notification notification) {
        if (!notificationMap.containsKey(notification.getNotificationType())) {
            throw new IllegalArgumentException("Notification type not supported: "
                    + notification.getNotificationType());
        }
        notificationMap.get(notification.getNotificationType()).accept(notification);
    }
}
