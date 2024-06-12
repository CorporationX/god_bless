package faang.school.godbless.lambdas.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        if (type == null || type.isEmpty() || type.isBlank()) {
            throw new IllegalArgumentException("Type can`t be empty");
        }

        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        handlers.get(notification.getType()).accept(notification);
    }
}
