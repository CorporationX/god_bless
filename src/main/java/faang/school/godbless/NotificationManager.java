package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> consumers = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> consumer) {
        consumers.put(notificationType, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = consumers.get(notification.getType());

        if (consumer != null) consumer.accept(notification);
        else System.out.println("No consumer found for notification type: " + notification.getType());
    }
}

