package school.faang.sprint2.bjs2_57916;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(@NonNull Notification notification) {
        notifications.get(notification.getType()).accept(notification);
    }
}
