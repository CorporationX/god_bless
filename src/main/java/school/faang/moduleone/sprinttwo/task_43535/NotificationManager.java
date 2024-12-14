package school.faang.moduleone.sprinttwo.task_43535;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers;
    private final Map<String, NotificationFilter<Notification>> contentFilters;


    public NotificationManager() {
        this.notificationHandlers = new HashMap<>();
        this.contentFilters = new HashMap<>();
    }

    public void registerHandler(String notificationType, Consumer<Notification> notificationHandler) {
        notificationHandlers.put(notificationType, notificationHandler);
    }

    public void registerFilter(String notificationType, NotificationFilter<Notification> filter) {
        contentFilters.put(notificationType, filter);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationHandler = notificationHandlers.get(notification.getType());
        NotificationFilter<Notification> filter = contentFilters.getOrDefault(notification.getType(), obj -> obj);
        notificationHandler.accept(filter.filter(notification));
    }
}
