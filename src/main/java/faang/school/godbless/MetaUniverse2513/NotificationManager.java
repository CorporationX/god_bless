package faang.school.godbless.MetaUniverse2513;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    static Map<String, Consumer<Notification>> notificationSender = new HashMap<>();
    static Map<String, Predicate<Notification>> notificationFilter = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> something) {
        if (!notificationSender.containsKey(type)) {
            notificationSender.put(type, something);
        }
    }

    public void registerFilter(String message, Predicate<Notification> something) {
            notificationFilter.put(message, something);
    }

    public void filterNotifications(Notification notification) {
        for (var entry : notificationFilter.entrySet()) {
            if (entry.getKey().equals(notification.getMessage())) {
                entry.getValue().test(notification);
            }
        }
    }

    public void sendNotification(Notification notification) {
        for (var entry : notificationSender.entrySet()) {
            if (entry.getKey().equals(notification.getType())) {
                entry.getValue().accept(notification);
            }
        }
    }
}
