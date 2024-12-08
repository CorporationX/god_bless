package school.faang.meta_universe;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificator) {
        notifications.putIfAbsent(notificationType, notificator);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificator = notifications.get(notification.getType());
        if (notificator == null) {
            log.info("notification type: {} - not found", notification.getType());
        } else {
            notificator.accept(notification);
        }
    }
}
