package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlerNotification = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlerNotification.put(type, handler);
    }

    public void sendNotification(Notification notification) {

    }


}
