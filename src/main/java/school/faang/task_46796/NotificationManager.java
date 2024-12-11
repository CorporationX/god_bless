package school.faang.task_46796;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    protected void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    protected void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.err.println("Notification type " + notification.getType() + " not found");
        }
    }
}
