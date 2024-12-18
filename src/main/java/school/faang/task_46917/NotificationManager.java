package school.faang.task_46917;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHander(String type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        for (Map.Entry<String, Consumer<Notification>> entry : notifications.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(notification.getType())) {
                entry.getValue().accept(notification);
            }
        }
    }
}
