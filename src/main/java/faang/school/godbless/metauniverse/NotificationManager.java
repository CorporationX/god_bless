package faang.school.godbless.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map <String, Consumer<Notification>> handlers = new HashMap<>();
    public void registerHandler (String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }
    public void sendNotification(Notification notification) {
        String type = notification.getType();
        Consumer<Notification> handler = handlers.get(type);
        if(handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler registered: " + type);
        }
    }
}
