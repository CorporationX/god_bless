package school.faang.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlers;

    public NotificationManager() {
        this.handlers = new HashMap<>();
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler registered for type: " + notification.getType());
        }
    }
}
