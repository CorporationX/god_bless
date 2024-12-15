package school.faang.task_46867;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();
    private final Map<String, Predicate<Notification>> notificationsFilter = new HashMap<>();
    private final Map<String, Function<Notification, String>> notificationFunctions = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> notificationConsumer) {
        notifications.put(id, notificationConsumer);
    }

    public void registerFilter(String id, Predicate<Notification> filter) {
        notificationsFilter.put(id, filter);
    }

    public void registerFunction(String id, Function<Notification, String> function) {
        notificationFunctions.put(id, function);
    }

    public void sendNotification(Notification notification) {
        if(notificationsFilter.containsKey(notification.getType())) {
            if(notificationsFilter.get(notification.getType()).test(notification)) {
                if(notificationFunctions.containsKey(notification.getType())) {
                    System.out.println(notificationFunctions.get(notification.getType()).apply(notification));
                    return;
                }
                System.out.println("This notification can't be send");
                return;
            }
        }
        notifications.get(notification.getType()).accept(notification);
    }
}
