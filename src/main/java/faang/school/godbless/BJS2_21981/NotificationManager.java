package faang.school.godbless.BJS2_21981;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> consumer) {
        handlers.put(notificationId, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        }
    }

}
