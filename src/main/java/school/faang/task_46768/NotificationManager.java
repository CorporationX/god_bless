package school.faang.task_46768;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlersByType = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationHandler) {
        notificationHandlersByType.put(notificationType, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationHandlersByType.get(notification.getType());

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler for notification type '" + notification.getType() + "' is found");
        }
    }
}
