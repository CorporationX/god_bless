package school.faang.meta.universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlersByNotification = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlersByNotification.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = handlersByNotification.get(notification.getType());
        notificationConsumer.accept(notification);

    }
}
