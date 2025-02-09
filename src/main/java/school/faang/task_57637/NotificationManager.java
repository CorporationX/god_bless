package school.faang.task_57637;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationTypeConsumerMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationTypeConsumerMap.put(type, handler);

    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationTypeConsumerMap.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        }

    }


}
