package school.faang.bjs2_87671;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> notificationActions = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationActions.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        notificationActions.get(notification.getType()).accept(notification);
    }
}
