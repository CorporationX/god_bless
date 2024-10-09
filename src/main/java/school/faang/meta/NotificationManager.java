package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private static final Map<String, Function<Notification, Notification>> filters = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void registerFilter(String type, Function<Notification, Notification> filter) {
        filters.put(type, filter);
    }

    public void sendNotification(Notification notification) {
        Function<Notification, Notification> filter = filters.get(notification.getType());
        if (filter != null) {
            notification = filter.apply(notification);
        }
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler == null) {
            throw new IllegalArgumentException("Handler for this notification not found!");
        }
        handler.accept(notification);
    }
}