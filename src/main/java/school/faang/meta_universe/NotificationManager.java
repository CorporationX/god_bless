package school.faang.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> hendlerMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.hendlerMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = this.hendlerMap.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Warning: no found type of notification " + notification.getType());
        }
    }
}
