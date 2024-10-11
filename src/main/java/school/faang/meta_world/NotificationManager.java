package school.faang.meta_world;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> alertsAndTheirHandlers;

    public NotificationManager() {
        alertsAndTheirHandlers = new HashMap<>();
    }

    public void registerHandler(String idNotification, Consumer<Notification> consumer) {
        alertsAndTheirHandlers.put(idNotification, consumer);
    }
    public void sendNotification(Notification notification) {
        alertsAndTheirHandlers.get(notification.type()).accept(notification);
    }
}
