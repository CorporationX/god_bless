package school.faang.meta;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Setter
public class NotificationManager {
    private final Map<Notification.NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private Predicate<Notification> filter = notification -> true;
    private Function<Notification, Notification> corrector = notification -> notification;

    public void registerHandler(Notification.NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler registered for type: " + notification.getType());
        }
    }
}
