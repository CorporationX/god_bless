package bjs257936;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationToConsumer = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler,
                                Predicate<NotificationType> filter) {
        filter.test(type);
        notificationToConsumer.put(type, handler);
    }

    public void sendNotification(Notification notification, Function<Notification, String> transformer) {
        transformer.apply(notification);
        Objects.requireNonNull(notificationToConsumer.get(notification.getType())).accept(notification);
    }
}
