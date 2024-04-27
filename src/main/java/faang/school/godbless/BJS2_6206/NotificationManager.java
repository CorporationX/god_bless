package faang.school.godbless.BJS2_6206;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationHandler) {
        notificationHandlers.put(notificationType, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationHandler = notificationHandlers.get(notification.getType());
        if (notificationHandler !=null) {
            notificationHandler.accept(notification);
        }
    }
}
