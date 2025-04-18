package metauniverse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final List<Function<Notification, Notification>> modifiers = new ArrayList<>();

    public void addHandler(NotificationType type, Consumer<Notification> handler) {
        this.handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (!this.filterBefore(notification)) {
            return;
        }
        notification = this.modifyBefore(notification);

        Consumer<Notification> handler = this.handlers.get(notification.getType());

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler for type: " + notification.getType());
        }
    }

    private boolean filterBefore(Notification notification) {
        for (Predicate<Notification> filter : this.filters) {
            if (!filter.test(notification)) {
                System.out.println("Notification blocked by filter: " + notification.getMessage());
                return false;
            }
        }
        return true;
    }

    private Notification modifyBefore(Notification notification) {
        for (Function<Notification, Notification> modifier : this.modifiers) {
            notification = modifier.apply(notification);
        }
        return notification;
    }

    public void addFilter(Predicate<Notification> filter) {
        this.filters.add(filter);
    }

    public void addModifier(Function<Notification, Notification> modifier) {
        this.modifiers.add(modifier);
    }
}
