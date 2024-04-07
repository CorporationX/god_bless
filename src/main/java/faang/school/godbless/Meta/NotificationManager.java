package faang.school.godbless.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers;

    public NotificationManager() {
        this.handlers = new HashMap<>();
    }

    public void registerHandler(String type, Consumer<Notification> consumer) {
        if (type == null || consumer == null) {
            return;
        }
        handlers.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (!handlers.containsKey(notification.getType())) {
            return;
        }
        handlers.get(notification.getType()).accept(notification);
    }
}
