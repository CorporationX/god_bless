package school.faang.task_46766;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandler = new HashMap<>();

    public void registerHandler(NotificationType notificationType, Consumer<Notification> handler) {
        if (notificationHandler.containsKey(notificationType)) {
            throw new IllegalArgumentException("The notification already exists");
        } else {
            notificationHandler.put(notificationType, handler);
        }
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationHandler.get(notification.getNotificationType());
        if (handler == null) {
            throw new IllegalArgumentException("There is no notification");
        } else {
            handler.accept(notification);
        }
    }
}