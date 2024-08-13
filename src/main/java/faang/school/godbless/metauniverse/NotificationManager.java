package faang.school.godbless.metauniverse;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(@NonNull String type, @NonNull Consumer<Notification> handler) {
        if (notificationHandlers.containsKey(type)) {
            System.err.println("handler for this type of notification handler already registered");
        } else {
            notificationHandlers.put(type, handler);
        }
    }

    public void sendNotification(@NonNull Notification notification) {
        if (notificationHandlers.containsKey(notification.getType())) {
            notificationHandlers.get(notification.getType()).accept(notification);
        } else {
            System.err.println("no handler for this notification");
        }
    }
}
