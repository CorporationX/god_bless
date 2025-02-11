package school.faang.metauniverse;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new NullPointerException("Notification is null");
        }
        if (notifications.containsKey(notification.getType())) {
            notifications.get(notification.getType()).accept(notification);
        } else {
            log.info("Notification type {} is not registered", notification.getType());
        }
    }

    public void updateNotification(Notification notification, Function<Notification, Notification> function) {
        if (notification == null) {
            throw new NullPointerException("Notification is null");
        } else if (function == null) {
            throw new NullPointerException("Function is null");
        }
        notifications.get(notification.getType()).accept(function.apply(notification));
    }
}
