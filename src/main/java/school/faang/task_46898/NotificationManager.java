package school.faang.task_46898;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<String, Predicate<Notification>> filters = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> modifiers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void registerFilter(String type, Predicate<Notification> filter) {
        filters.put(type, filter);
    }

    public void registerModifier(String type, Function<Notification, Notification> modifier) {
        modifiers.put(type, modifier);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();

        Function<Notification, Notification> modifier = modifiers.get(type);
        if (modifier != null) {
            notification = modifier.apply(notification);
        }

        Predicate<Notification> filter = filters.get(type);
        if (filter != null && !filter.test(notification)) {
            System.out.println("Notification blocked by filter: " + notification.getMessage());
            return;
        }

        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler for type: " + notification.getType());
        }
    }
}
