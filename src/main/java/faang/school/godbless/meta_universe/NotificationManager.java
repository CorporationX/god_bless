package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> NOTIFICATIONS = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        NOTIFICATIONS.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (NOTIFICATIONS.containsKey(notification.type())) {
            NOTIFICATIONS.get(notification.type()).accept(notification);
        }
    }
}
