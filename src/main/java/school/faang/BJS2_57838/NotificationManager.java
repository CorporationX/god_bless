package school.faang.BJS2_57838;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public  void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(@NonNull Notification notification) {
        if (!notifications.containsKey(notification.getType())) {
            throw new IllegalArgumentException("Данного типа нет");
        }
        notifications.get(notification.getType()).accept(notification);


    }
}
