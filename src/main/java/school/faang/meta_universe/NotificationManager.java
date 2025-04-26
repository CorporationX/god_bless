package school.faang.meta_universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    public final Map<NotificationType, Consumer<Notification>> notificationTypeConsumer = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final List<Function<Notification, Notification>> correctors = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (!notificationTypeConsumer.containsKey(type)) {
            notificationTypeConsumer.put(type, handler);
        }
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationTypeConsumer.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println(notification.getType() + " not found");
        }
    }

    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }

    public void addCorrector(Function<Notification, Notification> corrector) {
        correctors.add(corrector);
    }

}
