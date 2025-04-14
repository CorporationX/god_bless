package school.faang.bjs2_70565;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {
    private final Map<NotificationType, NotificationHandlers<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, NotificationHandlers<Notification> notificationHandlers) {
        this.handlers.putIfAbsent(type, notificationHandlers);
    }

    public void sendNotification(Notification notification) {
        NotificationHandlers<Notification> notificationHandlers = handlers.get(notification.getType());
        if (notificationHandlers == null) {
            return;
        }
        if (notificationHandlers.filter().test(notification)) {
            String text = notificationHandlers.footer().apply(notification);
            notification.setMessage(text);
            notificationHandlers.action().accept(notification);
        }
    }
}
