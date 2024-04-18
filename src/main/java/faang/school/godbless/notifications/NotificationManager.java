package faang.school.godbless.notifications;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> consumerMap = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> consumer) {
        consumerMap.put(notificationId, consumer);
    }

    public void sendNotification(Notification notification) {
        consumerMap.getOrDefault(notification.getType(), consumerMap.get("defaultValue"));
    }
}
