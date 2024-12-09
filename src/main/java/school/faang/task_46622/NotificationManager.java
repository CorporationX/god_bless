package school.faang.task_46622;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.task_46622.entity.Notification;
import school.faang.task_46622.entity.TypeNotification;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Logger log = LoggerFactory.getLogger(NotificationManager.class);
    private final Map<TypeNotification, Consumer<Notification>> listener = new HashMap<>();

    public void registerHandler(TypeNotification notificationType, Consumer<Notification> handler) {
        listener.put(notificationType, handler);
        log.info("Registered handler for {}", notificationType);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = listener.get(notification.getType());
        if (isValid(notification)) {
            handler.accept(notification);
        }
    }

    private boolean isValid(Notification notification) {
        Consumer<Notification> handler = listener.get(notification.getType());
        if (handler == null) {
            throw new IllegalArgumentException("Handler not registered  or no data available for the notification type: \"" + notification.getType());
        }
        return true;
    }
}

