package BJS2_10010;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationHandler = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> handler) {
        notificationHandler.put(notificationId, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationHandler.get(notification.getType());

        if (handler != null) {
            handler.accept(notification);
        }
    }
}