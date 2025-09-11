package school.faang.bjs2_91711;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) throws Exception {
        if (type == null || handler == null) {
            throw new Exception("Одно из полей равно null.");
        }
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = notificationHandlers.get(notification.getType());
        consumer.accept(notification);
    }
}
