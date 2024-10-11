package school.faang.meta_world;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> NOTIFICATION_DESCRIPTION;

    public NotificationManager() {
        NOTIFICATION_DESCRIPTION = new HashMap<>();
    }

    public void registerHandler(String idNotification, Consumer<Notification> consumer) {
        NOTIFICATION_DESCRIPTION.put(idNotification, consumer);
    }
    public void sendNotification(Notification notification) {
        NOTIFICATION_DESCRIPTION.get(notification.type()).accept(notification);
    }
}
