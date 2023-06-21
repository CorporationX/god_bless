package faang.school.godbless.meta.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notification) {
        notificationMap.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        notificationMap.get(notification.getType()).accept(notification);
    }
}
