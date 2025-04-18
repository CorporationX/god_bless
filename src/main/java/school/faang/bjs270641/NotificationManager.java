package school.faang.bjs270641;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> manager = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        manager.put(type, handler);
    }

    public void sendNotification(Notification notification, Predicate<Notification> filter,
                                 Function<Notification, Notification> transformer) {
        if (filter.test(notification)) {
            notification = transformer.apply(notification);
            manager.get(notification.type()).accept(notification);
        }
    }
}
