package faang.school.godbless.BJS2_5187;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer> handlers = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        if (handlers.containsKey(notification.getType())) {
            handlers.get(notification.getType()).accept(notification);
        } else {
            System.out.println("This notification type is not available at the moment!");
        }
    }
}