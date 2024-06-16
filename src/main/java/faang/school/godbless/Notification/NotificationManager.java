package faang.school.godbless.Notification;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationHandler;

    public NotificationManager() {
        this.notificationHandler = new HashMap<>();
    }

    public void registerHandler(String notificationId, Consumer<Notification> handler) {
        notificationHandler.put(notificationId, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationHandler.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler registered for this notification"  + notification.getType());
        }



    }
}
