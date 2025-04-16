package school.faang.bjs270631;

import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> typedNotifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || handler == null) {
            log.error("Notification type [{}] or handler [{}] is not provided.", type == null, handler == null);
            return;
        }
        typedNotifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            log.error("Notification is not provided.");
            return;
        }

        Consumer<Notification> requiredAction = typedNotifications.get(notification.getNotificationType());
        if (requiredAction == null) {
            log.error("Handler not registered for this notification type [{}], message: {}",
                    notification.getNotificationType(), notification.getMessage());
            return;
        }
        requiredAction.accept(notification);
    }
}
