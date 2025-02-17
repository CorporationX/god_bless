package school.faang.task_57967;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@EqualsAndHashCode
@ToString
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationMap = new HashMap<>();
    @Setter
    private Predicate<Notification> filter;
    @Setter
    private Function<Notification, Notification> corrector;

    public void registerHandler(@NonNull NotificationType type,
                                @NonNull Consumer<Notification> handler) {
        notificationMap.put(type, handler);
    }

    public void sendNotification(Notification notification) throws NotificationException {
        if (notification.getType() == null) {
            throw new InvalidNotificationTypeException(notification.getType().toString());
        }
        if (filter != null && !filter.test(notification)) {
            throw new FilteredNotificationException(notification.getMessage());
        }

        if (corrector != null) {
            notification = corrector.apply(notification);
        }

        Consumer<Notification> handler = notificationMap.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            throw new InvalidNotificationTypeException(notification.getType().toString());
        }
    }
}
