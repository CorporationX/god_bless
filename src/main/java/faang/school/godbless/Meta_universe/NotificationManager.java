package faang.school.godbless.Meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> consumer){
        notifications.put(notificationId, consumer);
    }

    public void sendNotification(Notification notification){
        Consumer<Notification> consumer = notifications.get(notification.getType());
        consumer.accept(notification);
    }

    public boolean filterNotification(Notification notification, NotificationFilter notificationFilter){
        return notificationFilter.filter(notification.getMessage());
    }
}
