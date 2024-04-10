package BJS2_5152;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        handlers.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        if (!handlers.containsKey(notification.getType())) {
            throw new NoSuchElementException("No handler with this name");
        }
        handlers.get(notification.getType()).accept(notification);
    }
}
