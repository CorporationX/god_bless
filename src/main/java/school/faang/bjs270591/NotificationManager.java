package school.faang.bjs270591;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
        log.info("Registered handler for {}", type);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationHandlers.get(notification.getType());
        if (handler != null) {
            log.info("Sending notification for {}", notification.getType());
            handler.accept(notification);
        } else {
            log.info("No handler for {}", notification.getType());
        }
    }
}
