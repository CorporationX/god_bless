package bjs2_34724;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (handlers.containsKey(notification.getType())) {
            handlers.get(notification.getType()).accept(notification);
        }
    }

}
