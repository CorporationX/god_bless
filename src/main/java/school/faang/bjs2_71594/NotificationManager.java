package school.faang.bjs2_71594;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (this.handlers.containsKey(notification.getType())) {
            this.handlers.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Unknown notification type");
        }
    }
}
