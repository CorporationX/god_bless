package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class NotificationManager {
    private Map<Notification.NotificationType, Consumer<Notification>> handlers = new HashMap<>();


    public void registerHandler(Notification.NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("handler is empty " + notification.getType());
        }

    }
}
