package school.faang.BJS234626;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String alert, Consumer<Notification> notification) {
        handlers.put(alert, notification);
    }

    public void sendNotification(Notification notification) {
        handlers.get(notification.getType()).accept(notification);
    }
}
