package school.faang_sprint_2.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String identifier, Consumer<Notification> consumer) {
        notifications.put(identifier, consumer);
    }

    public void sendNotification(Notification notification) {
        notifications.get(notification.type()).accept(notification);
    }
}
