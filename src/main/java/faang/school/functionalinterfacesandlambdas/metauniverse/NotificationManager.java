package faang.school.functionalinterfacesandlambdas.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> notificationHandler = new HashMap<>();

    private static final String NOTIFICATION_ERROR = "Notification was not provided";

    public void registerHandler(String notification, Consumer<Notification> consumer) {
        if (notification == null || notification.isBlank()) {
            throw new IllegalArgumentException(NOTIFICATION_ERROR);
        }
        if (consumer == null) {
            throw new IllegalArgumentException("Consumer was not provided");
        }
        notificationHandler.put(notification, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException(NOTIFICATION_ERROR);
        }
        if (notificationHandler.containsKey(notification.getType())) {
            notificationHandler.get(notification.getType()).accept(notification);
        }
    }
}
