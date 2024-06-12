package faang.school.godbless.BJS2_10059;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    Map<String, Consumer<Notification>> notifications = new HashMap<>();

    void registerHandler(String id, Consumer<Notification> handler) {
        notifications.put(id, handler);
    }

    void sendNotification(Notification notification) {
        Consumer<Notification> consumer = notifications.get(notification.getType());
        consumer.accept(notification);
    }
}
