package school.faang.metauniverse;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final List<Function<Notification, Notification>> processors = new ArrayList<>();

    public void addHandler(NotificationType type, Consumer<Notification> handler) {
        this.handlers.put(type, handler);
    }

    public void addFilter(Predicate<Notification> filter) {
        this.filters.add(filter);
    }

    public void addProcessor(Function<Notification, Notification> processor) {
        this.processors.add(processor);
    }

    public void sendNotification(Notification notification) {
        if (!filterBefore(notification)) {
            System.out.println("Notification blocked: " + notification.getMessage());
            return;
        }

        Notification processedNotification = processBefore(notification);

        Consumer<Notification> handler = this.handlers.get(processedNotification.getType());
        if (handler != null) {
            handler.accept(processedNotification);
        } else {
            System.out.println("No handler registered for type: " + processedNotification.getType());
        }
    }

    private boolean filterBefore(Notification notification) {
        for (Predicate<Notification> filter : this.filters) {
            if (!filter.test(notification)) {
                return false;
            }
        }
        return true;
    }

    private Notification processBefore(Notification notification) {
        Notification result = notification;
        for (Function<Notification, Notification> processor : this.processors) {
            result = processor.apply(result);
        }
        return result;
    }
}
