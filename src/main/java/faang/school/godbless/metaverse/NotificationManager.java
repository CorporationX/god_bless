package faang.school.godbless.metaverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> mapNotifications = new HashMap<>();

    public void registerHandler(String notification, Consumer<Notification> consumer) {
        mapNotifications.put(notification, consumer);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        Consumer<Notification> consumer = mapNotifications.get(type);
        consumer.accept(notification);
    }
}
