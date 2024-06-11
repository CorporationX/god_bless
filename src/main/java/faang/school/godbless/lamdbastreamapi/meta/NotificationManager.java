package faang.school.godbless.lamdbastreamapi.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> notificationProcessor = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        notificationProcessor.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        notificationProcessor.get(notification.getType()).accept(notification);
    }
}
