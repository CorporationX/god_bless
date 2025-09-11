package school.faang.bjs2_88805;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> handlerMap = new HashMap<>();

    protected void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlerMap.put(type, handler);
    }

    protected void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = handlerMap.get(notification.getType());
        if (notificationConsumer != null) {
            notificationConsumer.accept(notification);
        }
    }
}
