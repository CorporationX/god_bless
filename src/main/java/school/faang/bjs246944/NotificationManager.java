package school.faang.bjs246944;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notification) {
        notifications.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();

        if (notifications.containsKey(type)) {
            notifications.get(type).accept(notification);
        }
    }
}
