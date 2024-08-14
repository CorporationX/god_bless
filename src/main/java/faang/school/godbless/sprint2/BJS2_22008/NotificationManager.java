package faang.school.godbless.sprint2.BJS2_22008;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private Map<String, Consumer<Notification>> notificationHandlers;
    private Map<Predicate<Notification>, Consumer<Notification>> notificationFilters;

    public NotificationManager() {
        notificationHandlers = new HashMap<>();
        notificationFilters = new HashMap<>();
    }

    protected void registerHandler(String identifier, Consumer<Notification> handler) {
        Objects.requireNonNull(handler, "Handler can not be null");

        if (notificationHandlers.putIfAbsent(identifier, handler) != null) {
            System.out.println("Warning: handler " + identifier + " is already registered");
        } else {
            System.out.println("Handler " + identifier + " registered");
        }
    }

    protected void addFilter(Predicate<Notification> filter, Consumer<Notification> handler) {
        Objects.requireNonNull(filter, "Filter can not be null");
        Objects.requireNonNull(handler, "Handler can not be null");

        if (notificationFilters.putIfAbsent(filter, handler) != null) {
            System.out.println("Warning: filter is already registered");
        } else {
            System.out.println("Filter registered");
        }
    }

    protected void sendNotification(Notification notification) {

        Objects.requireNonNull(notification, "Notification can not be null");

        if (!notificationHandlers.containsKey(notification.getType())) {
            throw new RuntimeException("Error: handler " + notification.getType() + " is not registered");
        }

        for (Map.Entry<Predicate<Notification>, Consumer<Notification>> entry : notificationFilters.entrySet()) {
            if (entry.getKey().test(notification)) {
                entry.getValue().accept(notification);
                return;
            }
        }

        notificationHandlers.get(notification.getType()).accept(notification);
    }
}
