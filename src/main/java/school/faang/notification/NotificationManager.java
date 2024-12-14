package school.faang.notification;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private Map<String, Predicate<Notification>> filters = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler registered for notification type: " + notification.getType());
        }
    }

    public void registerFilter(String filterType, Predicate<Notification> filter) {
        filters.put(filterType, filter);
    }

    public boolean isInappropriate(Notification notification) {
        return filters.values().stream().anyMatch(filter -> filter.test(notification));
    }

}
