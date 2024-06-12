package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> manager) {
        notifications.put(type, manager);
    }

    public void sendNotification(Notification notification) {
        notifications.get(notification.getType());
    }
}
