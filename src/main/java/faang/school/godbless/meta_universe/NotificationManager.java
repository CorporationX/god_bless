package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationHandler) {
        notificationHandlers.put(type, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        notificationHandlers.get(notification.getType()).accept(notification);
    }
}
