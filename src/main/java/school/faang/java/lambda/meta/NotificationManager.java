package school.faang.java.lambda.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationConsumerMap;

    {
        notificationConsumerMap = new HashMap<>();
    }

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        notificationConsumerMap.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        notificationConsumerMap.get(notification.getType()).accept(notification);
    }
}