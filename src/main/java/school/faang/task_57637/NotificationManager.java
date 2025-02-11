package school.faang.task_57637;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationTypeConsumerMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null) {
            throw new IllegalArgumentException("type не может быть null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("handler не может быть null");
        }
        notificationTypeConsumerMap.put(type, handler);

    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationTypeConsumerMap.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        }
    }

    public Notification notificationUpdateMessage(Notification notification,
                                                  Function<Notification, Notification> function) {
        if (notification == null) {
            throw new IllegalArgumentException("notification не может быть null");
        }
        if (function == null) {
            throw new IllegalArgumentException("function не может быть null");
        }
        return function.apply(notification);
    }
}
