package faang.school.godbless.BJS2_22042;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationTypes = new HashMap<>();
    public void registerHandler(String notification, Consumer<Notification> notificationConsumer) {
        notificationTypes.put(notification, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        notificationTypes.get(notification.getType()).accept(notification);
    }
}
