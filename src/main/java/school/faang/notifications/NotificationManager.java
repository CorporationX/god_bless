package school.faang.notifications;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();
    private final Map<String, Predicate<String>> filters = new HashMap<>();

    public void registerNotification(String type, Consumer<Notification> consumer) {
        notifications.put(type, consumer);
    }

    public void registerFilter(String type, Predicate<String> predicate) {
        filters.put(type, predicate);
    }

    public void sendNotification(Notification notification) {
        Predicate<String> filter = filters.get(notification.getType());

        if (filter != null && filter.test(notification.getMessage().toLowerCase())) {
            System.out.println(
                    "уведмеление типа " + notification.getType() + " не прошло проверку на неприемлемый контент");
            return;
        }
        notifications.get(notification.getType()).accept(notification);
    }


}
