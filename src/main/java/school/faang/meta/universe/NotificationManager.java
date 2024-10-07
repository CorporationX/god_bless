package school.faang.meta.universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> identifiers = new HashMap<>();

    public void registerHandler(String identifier, Consumer<Notification> handler) {
        identifiers.put(identifier, handler);
    }

    public void sendNotification(Notification notification) {
        identifiers.get(notification.type()).accept(notification);
    }
}
