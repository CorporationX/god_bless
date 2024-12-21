package school.faang.task_46266;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        map.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (map.get(notification.type()) == null) {
            System.out.println("такого уведомленяи нет");
        } else {
            map.get(notification.type()).accept(notification);
        }

    }
}
