package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    public Map<String, Consumer<Notification>> handlersByType = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        if (notificationType != null) {
            handlersByType.putIfAbsent(notificationType, handler);
        }
    }

    public void sendNotification(Notification notification) {
        handlersByType.get(notification.getType()).accept(notification);
    }
}
