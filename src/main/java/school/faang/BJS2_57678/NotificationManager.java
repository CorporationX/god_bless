package school.faang.BJS2_57678;

import lombok.Setter;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap();
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    @Setter
    private Function<Notification, Notification> corrector = notification -> notification;

    private boolean checkMessage(Notification notification) {
        if (notification == null || notification.getMessage() == null || notification.getMessage().trim().isEmpty()) {
            throw new IllegalArgumentException("Notification or message cannot be null or empty");
        }

        return filters.stream().anyMatch(filter -> filter.test(notification));
    }

    public void addFilter(Predicate<Notification> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("Filter can't be null");
        }
        filters.add(filter);
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || handler == null) {
            throw new IllegalArgumentException(
                    String.format("NotificationType or handler can't be null ,NotificationType: %s, handler%s",
                            type, handler)
            );
        }

        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification can't be null");
        }

        var handler = notificationHandlers.get(notification.getType());
        if (handler == null) {
            throw new IllegalArgumentException("No handler found for notification type: " + notification.getType());
        }

        if (checkMessage(notification)) {
            System.out.println("Собщение содержит незензурную лексику");
            return;
        }
        handler.accept(corrector.apply(notification));
    }

    public Map<NotificationType, Consumer<Notification>> getNotificationHandlers() {
        return Collections.unmodifiableMap(notificationHandlers);
    }
}
