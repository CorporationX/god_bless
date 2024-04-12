package faang.school.godbless.BJS2_5265;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        notifications.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        if (notification.getType() != null) {
            notifications.get(notification.getType()).accept(notification);
        } else {
            throw new IllegalArgumentException("переданные аргумент типа Notification равен null");
        }

    }
}
