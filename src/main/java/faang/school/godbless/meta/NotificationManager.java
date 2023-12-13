package faang.school.godbless.meta;

import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> handlers;

    void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    void sendNotification(Notification notification) {
        handlers.get(notification.type).accept(notification);
    }
}
