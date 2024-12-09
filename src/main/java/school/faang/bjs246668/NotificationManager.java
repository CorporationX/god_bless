package school.faang.bjs246668;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> fun) {
        notifications.put(type, fun);
    }

    public void sendNotification(Notification notification) {
        if (!notifications.containsKey(notification.getType())) {
            throw new IllegalArgumentException("This type is not found !!!");
        }
        notifications.get(notification.getType()).accept(notification);
    }
}
