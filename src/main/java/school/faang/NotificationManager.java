package school.faang;

import lombok.Setter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Setter
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private Predicate<Notification> filter = n -> true;
    private Function<Notification, Notification> messageProcessor = Function.identity();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (filter.test(notification)) {
            Notification processedNotification = messageProcessor.apply(notification);
            Consumer<Notification> handler = handlers.get(processedNotification.getType());
            if (handler != null) {
                handler.accept(processedNotification);
            } else {
                System.out.println("No handler registered for: " + processedNotification.getType());
            }
        } else {
            System.out.println("Notification blocked by filter: " + notification.getMessage());
        }
    }
}