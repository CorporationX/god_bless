package school.faang.task_57659;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Predicate<Notification> predicate = n -> n.getMessage().equals("бл*ть");
        if (predicate.test(notification)) {
            throw new IllegalArgumentException("You can not write obscene language");
        }

        Consumer<Notification> consumer = notificationHandlers.get(notification.getType());
        if (consumer == null) {
            throw new IllegalArgumentException("Handler cant be null");
        }

        Function<Notification, Notification> function = x -> new Notification(x.getType(), x.getMessage() + ". META COMPANY");
        Notification formatedNotification = function.apply(notification);

        consumer.accept(formatedNotification);
    }


}
