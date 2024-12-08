package school.faang.task_46266;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        map.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        map.get(notification.getType()).accept(notification);
    }
}
