package school.faang.meta.universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> identifiers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        identifiers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        identifiers.get(notification.getType()).accept(notification);
    }
}
