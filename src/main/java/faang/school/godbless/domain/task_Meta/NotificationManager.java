package faang.school.godbless.domain.task_Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> handler) {
        notifications.put(notificationId, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumerNotification = notifications.get(notification.type());
        if (consumerNotification != null) {
            consumerNotification.accept(notification);
        }
    }

}
