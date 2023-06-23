package Meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> notification) {
        notificationMap.put(id, notification);
    }

    public void sendNotification(Notification notification) {
        notificationMap.get(notification.getType()).accept(notification);
    }

    public void filterAndSendNotification(Notification notification,
                                          Predicate<Notification> filter) {
        if (filter.test(notification)) {
            notificationMap.get(notification.getType()).accept(notification);
        }
    }

}
