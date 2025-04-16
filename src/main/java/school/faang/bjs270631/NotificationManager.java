package school.faang.bjs270631;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> typedNotifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        typedNotifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (typedNotifications.get(notification.getNotificationType()) == null) {
            log.info("Handler not registered for this notification type [{}], message: {}",
                    notification.getNotificationType(), notification.getMessage());
            return;
        }

        typedNotifications.get(notification.getNotificationType()).accept(notification);
    }
}
