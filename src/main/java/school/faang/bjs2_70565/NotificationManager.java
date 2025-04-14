package school.faang.bjs2_70565;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationsMap;

    public NotificationManager() {
        this.notificationsMap = new HashMap<>();
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationsMap.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification, Function<Notification, String> footer) {
        Consumer<Notification> consumer = notificationsMap.get(notification.getType());
        if (consumer != null) {
            notification.setMessage(footer.apply(notification));
            consumer.accept(notification);
        }
    }

    public boolean censored(Notification notification, Predicate<Notification> predicate) {
        return predicate.test(notification);
    }

}
