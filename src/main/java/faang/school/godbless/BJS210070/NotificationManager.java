package faang.school.godbless.BJS210070;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> consumerMap = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> notification) {
        consumerMap.put(notificationId, notification);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = consumerMap.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        }
    }
}
