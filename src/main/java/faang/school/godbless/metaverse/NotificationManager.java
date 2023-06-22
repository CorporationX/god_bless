package faang.school.godbless.metaverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String messageIdentifier, Consumer<Notification> handler) {
        handlers.put(messageIdentifier, handler);
    }

    public void sendNotification(Notification notification) {
        if (!(handlers.containsKey(notification.getType()))) {
            throw new IllegalArgumentException("Can not provide for processing by " + notification.getType());
        }
        handlers.get(notification.getType()).accept(notification);
    }
}
