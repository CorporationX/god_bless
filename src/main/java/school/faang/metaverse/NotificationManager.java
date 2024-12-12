package school.faang.metaverse;

import java.util.HashMap;
import java.util.function.Consumer;

public class NotificationManager {
    private final HashMap<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType notificationType, Consumer<Notification> handler) {
        if (notificationType == null || handler == null) {
            System.out.println("error: handler cannot register because notificationType is null or handler is null");
            return;
        }
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.type());
        if (handler == null) {
            System.out.println("error: handler does not exist");
            return;
        }
        handler.accept(notification);
    }
}
