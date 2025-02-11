package school.faang.BJS2_57678;

import java.util.*;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap();
    private final List<Predicate<Notification>> filters = new ArrayList<>();

    private boolean checkMessage(Notification notification) {
        if (notification == null || notification.getMessage() == null || notification.getMessage().trim().isEmpty()) {
            throw new IllegalArgumentException("Notification or message cannot be null or empty");
        }

        for (Predicate<Notification> filter : filters) {
            if (filter.check(notification)) {
                return true;
            }
        }
        return false;
    }

    public void addFilter(Predicate<Notification> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("Filter can't be null");
        }
        filters.add(filter);
    }

    public static void addSing(Function<Notification, String> sing, String companyName) {
        if (sing == null) {
            throw new IllegalArgumentException("sing can't be null");
        }
        Notification result = sing.apply(companyName);
        result.setMessage(String.format("%s from company %s", sing.apply(companyName).getMessage(), companyName));
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || handler == null) {
            throw new IllegalArgumentException("NotificationType or handler can't be null");
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
            System.out.println("Собщение содержит незензурную лекцику");
            return;
        }
        handler.accept(notification);
    }

    public Map<NotificationType, Consumer<Notification>> getNotificationHandlers() {
        return Collections.unmodifiableMap(notificationHandlers);
    }
}
