package notifications;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Setter
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private Predicate<Notification> filter;
    private Function<Notification, Notification> messageCorrector;

    private void validateInput(Object value, String errorMessage) {
        if (value == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        validateInput(handler, "Handler cannot be null.");

        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        validateInput(notification, "Notification cannot be null.");

        if (filter != null && filter.test(notification)) {
            System.out.println("Заблокированное сообщение: " + notification.getMessage());
            return;
        }
        if (messageCorrector != null) {
            notification = messageCorrector.apply(notification);
        }

        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            throw new IllegalArgumentException("No handler registered for type " + notification.getType());
        }
    }
}
