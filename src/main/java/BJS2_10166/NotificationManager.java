package BJS2_10166;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> sender = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        sender.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        sender.get(notification.type()).accept(notification);
    }
}
