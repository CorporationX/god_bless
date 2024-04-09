package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> handler) {
        notifications.put(notificationId, handler);
    }

    public void sendNotification(Notification notification) {
        notifications.get(notification.getType()).accept(notification);
    }
}
