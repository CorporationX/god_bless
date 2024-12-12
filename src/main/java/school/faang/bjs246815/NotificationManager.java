package school.faang.bjs246815;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        if (handler == null) {
            return;
        }
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            return;
        }
        handlers.get(notification.getType()).accept(notification);
    }
}
