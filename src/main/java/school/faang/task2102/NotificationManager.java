package school.faang.task2102;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<String, List<FilterType>> filters = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        this.handlers.put(notificationType, handler);
    }

    public void registerFilters(String notificationType, List<FilterType> filters) {
        this.filters.put(notificationType, filters);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            System.out.println("Notification cannot be null");
            return;
        }

        Notification notificationToSend = getFilteredNotification(notification);

        Consumer<Notification> handler = handlers.get(notificationToSend.type());
        if (handler != null) {
            handler.accept(notificationToSend);
        } else {
            System.out.println("No handler found for notification type: " + notificationToSend.type());
        }
    }

    private Notification getFilteredNotification(Notification notification) {
        List<FilterType> filters = this.filters.get(notification.type());
        if (filters != null) {
            return Filter.filterMessageContent(notification, filters);
        }
        return notification;
    }
}
