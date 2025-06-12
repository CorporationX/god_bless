package school.faang.bjs2_80567;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        for (Map.Entry<NotificationType, Consumer<Notification>> entry : handlers.entrySet()) {
            if (entry.getKey() == notification.getType()) {
                entry.getValue().accept(notification);
            }
        }
    }

}
