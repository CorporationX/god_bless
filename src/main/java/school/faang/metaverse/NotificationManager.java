package school.faang.metaverse;

import java.util.HashMap;
import java.util.function.Consumer;

public class NotificationManager {
    HashMap<String, Consumer<Notification>> handlers = new HashMap<>();
    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }
    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.type());
        handler.accept(notification);
    }
}
