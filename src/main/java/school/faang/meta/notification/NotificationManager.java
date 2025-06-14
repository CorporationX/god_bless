package school.faang.meta.notification;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> consumers = new HashMap<>();

    public boolean registerHandler(@NonNull NotificationType type,
                                   @NonNull Consumer<Notification> handler, boolean override) {
        Consumer<Notification> existing = consumers.get(type);
        if (existing != null) {
            if (!override) {
                System.out.printf("a notification handler for %s type is already registered " +
                        "and will not be overridden\n", type);
                return false;
            }
            System.out.printf("A notification handler for type %s is already registered " +
                    "and will be overridden.\n", type);
        }

        consumers.put(type, handler);
        return true;
    }

    public boolean sendNotification(@NonNull Notification notification) {
        if (!handlerIsRegistered(notification)) {
            return false;
        }

        consumers.get(notification.getType()).accept(notification);
        return true;
    }

    public boolean sendNotification(@NonNull Notification notification,
                                    @NonNull Predicate<Notification> predicate) {
        if (!handlerIsRegistered(notification)) {
            return false;
        }

        if (!predicate.test(notification)) {
            System.out.println("notification fails on demand");
            return false;
        }

        consumers.get(notification.getType()).accept(notification);
        return true;
    }

    public boolean sendNotification(@NonNull Notification mainNotification,
                                    @NonNull Function<Notification, Notification> processor) {
        if (!handlerIsRegistered(mainNotification)) {
            return false;
        }

        Notification processedNotification = processor.apply(mainNotification);
        consumers.get(processedNotification.getType()).accept(processedNotification);
        return true;
    }

    private boolean handlerIsRegistered(@NonNull Notification notification) {
        var type = notification.getType();
        if (!consumers.containsKey(type)) {
            System.out.printf("the handler for %s type is not registered\n", type);
            return false;
        }

        return true;
    }
}
