package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> consumer) {
        handlers.put(type, consumer);
    }

    void sendNotification(Notification notification) {
        if (handlers.containsKey(notification.getType())) {
            handlers.get(notification.getType())
                    .accept(notification);
        }
    }
}

