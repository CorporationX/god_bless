package school.faang.sprint_2.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<?>> notificationsMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        notificationsMap.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        notificationsMap.get(notification.getType());
    }
}
