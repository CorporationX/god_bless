package school.faang.sprint2task46878;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<NotificationTyp, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(NotificationTyp type, Consumer<Notification> notificationConsumer) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        if (notificationConsumer == null) {
            throw new IllegalArgumentException("Notification consumer cannot be null");
        }

        map.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }

        Consumer<Notification> notificationConsumer = map.get(notification.getType());

        if (notificationConsumer != null) {
            notificationConsumer.accept(notification);
        } else {
            System.out.println("No handler registered for type: " + notification.getType());
        }
    }
}