package school.faang.bjs2_91650;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Setter
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();
    private Predicate<Notification> filter = notification -> true;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (filter.test(notification)) {
            Consumer<Notification> handler = notificationHandlers.get(notification.getType());
            if (handler != null) {
                handler.accept(notification);
            } else {
                System.out.println("No handler registered for " + notification.getType());
            }
        } else {
            System.out.println("Notification blocked: " + notification.getMessage());
        }
    }
}