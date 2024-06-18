package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationHandler = new HashMap<>();


    public void registerHandler(String id, Consumer<Notification> notification) {
        notificationHandler.computeIfAbsent(id, value -> notification);
    }

    public void sendNotification(Notification notification) {
        Objects.requireNonNull(notification);
        String type = notification.type();
        if (notificationHandler.containsKey(type)) {
            notificationHandler.get(type).accept(notification);
        }
    }
}
