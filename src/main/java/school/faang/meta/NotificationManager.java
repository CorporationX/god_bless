package school.faang.meta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class NotificationManager {
    public static final Logger log = LoggerFactory.getLogger(NotificationManager.class);
    private final Map<Notification.NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(Notification.NotificationType type, Consumer<Notification> handler) {
        if (handlers.containsKey(type)) {
            log.warn("Handler for {} is being replaced", type);
        }
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

    public Notification createDefaultNotification() {
        Supplier<Notification> notificationSupplier = () -> new Notification(Notification.NotificationType.EMAIL,
                "Default message");
        return notificationSupplier.get();
    }

    public void sendNotificationWithPriority(Notification notification, String priority) {
        BiConsumer<Notification, String> notificationWithPriority = (n, p) -> {
            System.out.println("Sending " + n.getMessage() + " With priority: " + p);
        };
        notificationWithPriority.accept(notification, priority);
    }
}
