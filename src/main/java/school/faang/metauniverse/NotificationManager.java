package school.faang.metauniverse;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private Predicate<Notification> filter;
    private Function<Notification, Notification> modifier;

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(@NonNull Notification notification) {
        if (filter != null && filter.test(notification)) {
            System.out.println(String.format("Notification blocked"));
            return;
        }
        if (modifier != null) {
            notification = modifier.apply(notification);
        }
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler registered for this notification type");
        }
    }

    public void setFilter(@NonNull Predicate<Notification> filter) {
        this.filter = filter;
    }

    public void modifierNotification(@NonNull Function<Notification, Notification> modifier) {
        this.modifier = modifier;
    }
}
