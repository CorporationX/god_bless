package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    Map<String, Consumer<Notification>> handlers = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        handlers.put(type, notificationConsumer);
    }

    void sendNotification(Notification notification) {
        handlers.get(notification.getType())
                .accept(notification);
    }
}

