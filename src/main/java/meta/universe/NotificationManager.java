package meta.universe;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(@NonNull String type, @NonNull Consumer<Notification> handler) {
        if (notificationHandlers.containsKey(type)) {
            System.out.println("\nAlready have handler for this type of notification");
        } else {
            notificationHandlers.put(type, handler);
        }
    }

    public void sendNotification(@NonNull Notification notification) {
        if (notificationHandlers.containsKey(notification.getType())) {
            notificationHandlers.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Can't handle this notification. No handler");
        }
    }
}
