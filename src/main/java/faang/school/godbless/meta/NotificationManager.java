package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager  {
    private final Map<String, Consumer<Notification>> HANDLERS;

    public NotificationManager() {
        HANDLERS = new HashMap<>();
    }

    public void registerHandler(String notificationType, Consumer<Notification> consumer) {
        HANDLERS.put(notificationType, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = HANDLERS.get(notification.getType());
        if (consumer != null) {
            consumer.accept(notification);
        } else {
            throw new UnsupportedOperationException("No handler for a notification such as: " + notification.getType());
        }
    }
}
