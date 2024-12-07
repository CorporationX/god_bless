package school.faang.task_45689;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotifyType, Consumer<Notification>> tasks = new HashMap<>();

    public void registerHandler(NotifyType type, Consumer<Notification> handler) {
        tasks.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("notification can not be null");
        }

        tasks.computeIfPresent(notification.type(), (k, v) -> {
            v.accept(notification);
            return v;
        });
    }
}
