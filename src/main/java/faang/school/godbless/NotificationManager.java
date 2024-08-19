package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> consumer) {
        map.put(id, consumer);
    }

    public void sendNotification(Notification notification) {
        if (map.containsKey(notification.type)) {
            map.get(notification.type).accept(notification);
        }
    }
}
