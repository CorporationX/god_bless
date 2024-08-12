package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    public Map<String, Consumer<Notification>> notificationTypeMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        if (type != null) {
            notificationTypeMap.putIfAbsent(type, notificationConsumer);
        }
    }

    public void sendNotification(Notification notification) {
        notificationTypeMap.get(notification.getType()).accept(notification);
    }
}
