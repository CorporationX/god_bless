package faang.school.godbless.BJS2_2984;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        if (handlers.containsKey(type)) {
            throw new IllegalArgumentException("Handler already exists!");
        } else {
            handlers.put(type, handler);
        }
    }

    public void sendNotification(Notification notification) {
        if (!handlers.containsKey(notification.getType())) {
            throw new IllegalArgumentException("Handler don't exist!");
        } else {
            handlers.get(notification.getType()).accept(notification);
        }
    }

}

