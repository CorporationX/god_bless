package school.faang.BJS2_59960;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> map = new HashMap<>();

    void registerHandler(NotificationType type, Consumer<Notification> handler) {
        map.put(type, handler);
    }

    void sendNotification(Notification notification) {
        if (map.containsKey(notification.type)) {
            map.get(notification.type).accept(notification);
        }
    }
}
