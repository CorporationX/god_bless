package school.faang.meta_universe;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = this.handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            log.info("Warning: no found type of notification {}", notification.getType());
        }
    }
}
