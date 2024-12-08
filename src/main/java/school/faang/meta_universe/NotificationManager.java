package school.faang.meta_universe;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {

    public Map<String, String> registerHandler (String notificationId, Consumer<Notification>) {
        Map<String, String> notifications = new HashMap<>();
        notifications.putIfAbsent(notificationId, Consumer<T>);
    }
}
