package meta.universe;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(@NonNull String type, @NonNull Consumer<Notification> handler) {
        if (notificationHandlers.containsKey(type)) {
            throw new IllegalArgumentException("Already has handler for this type of message");
        } else {
            notificationHandlers.put(type, handler);
        }
    }

    public void sendNotification(@NonNull Notification notification) {
        if (notificationHandlers.containsKey(notification.getType())) {
            notificationHandlers.get(notification.getType()).accept(notification);
        } else {
            throw new NoSuchElementException("No handler for this type of message");
        }
    }
}
