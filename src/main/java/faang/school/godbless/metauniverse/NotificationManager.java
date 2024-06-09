package faang.school.godbless.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> handler) {
        handlers.put(notificationId, handler);
    }

    public void sendNotification(Notification notification) {
        String notificationId = notification.getType();
        Consumer<Notification> handler = handlers.get(notificationId);
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Handler not found for notification type: " + notificationId);
        }
    }
}
