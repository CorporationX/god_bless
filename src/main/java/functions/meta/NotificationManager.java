package functions.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> consumer) {
        notificationMap.put(id, consumer);
    }

    public void sendNotification(Notification notification, Predicate<Notification> predicate) {
        if (predicate.test(notification)) {
            notificationMap.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Invalid ID type");
        }
    }
}
