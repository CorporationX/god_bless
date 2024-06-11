package faang.school.godbless.BJS2_10079;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> notificationConsumer) {
        if (!notifications.containsKey(id)) {
            notifications.put(id, notificationConsumer);
        }
    }

    public void sendNotification(Notification notification) {
        notifications.get(notification.getType()).accept(notification);
    }
}
