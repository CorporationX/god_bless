package school.faang.bjs2_87643;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public boolean filterMessage(Notification notification, Predicate<Notification> filter) {
        return filter.test(notification);
    }

    public void correctionNotification(Notification notification,
                                       Function<Notification, Notification> function) {
        function.apply(notification);
    }

    public void sendNotification(Notification notification) {

        boolean isFiltred = filterMessage(notification,
                (message) -> new Random().nextBoolean());
        if (isFiltred) {
            NotificationType type = notification.getType();
            correctionNotification(notification,
                    (n) -> {
                        String message = notification.getMessage() + " |From Meta|";
                        notification.setMessage(message);
                        return n;
                    });

            Consumer<Notification> handler = handlers.get(type);
            if (handler == null) {
                throw new IllegalArgumentException("No handler registered for type: " + type);
            }
            handler.accept(notification);
        }
    }
}