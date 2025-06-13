package school.faang.bjs280619;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static school.faang.bjs280619.Notification.NotificationType;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<NotificationType, Predicate<Notification>> filters = new HashMap<>();
    private final Map<NotificationType, Function<Notification, Notification>> transformers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        NotificationType type = notification.getType();
        Objects.requireNonNull(notification, "Notification cannot be null");

        if (isFiltered(notification, type)) {
            return;
        }

        Notification transformedNotification = transform(notification, type);
        handle(transformedNotification, type);
    }

    private boolean isFiltered(Notification notification, NotificationType type) {
        Predicate<Notification> filter = filters.get(type);

        if (filter != null && filter.test(notification)) {
            System.out.println("Notification blocked by filter: " + notification.getMessage());
            return true;
        }
        return false;
    }

    private Notification transform(Notification notification, NotificationType type) {
        Function<Notification, Notification> transformer = transformers.get(type);
        return transformer != null ? transformer.apply(notification) : notification;
    }

    private void handle(Notification notification, NotificationType type) {
        Consumer<Notification> handler = handlers.get(type);

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler for " + type);
        }
    }

    public void addFilter(NotificationType type, Predicate<Notification> filter) {
        filters.put(type, filter);
    }

    public void addTransformer(NotificationType type, Function<Notification, Notification> transformer) {
        transformers.put(type, transformer);
    }
}
