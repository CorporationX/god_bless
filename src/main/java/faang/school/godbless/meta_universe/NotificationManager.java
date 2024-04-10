package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> handler) {
        if (notificationId.isEmpty()) {
            throw new IllegalArgumentException("The notification ID field is empty");
        }
        notifications.put(notificationId, handler);
    }

    public void sendNotification(Notification notification) {
        if (!notifications.containsKey(notification.getType())) {
            throw new IllegalArgumentException("There is no such handler key");
        }
        notifications.get(notification.getType()).accept(notification);
    }
}
