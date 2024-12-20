package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> func) {
        map.put(type, func);
    }

    void sendNotification(Notification notification) {
        map.get(notification.type);
    }
}
