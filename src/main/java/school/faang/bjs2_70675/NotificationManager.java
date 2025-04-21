package school.faang.bjs2_70675;

import lombok.Data;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers =
            new EnumMap<>(NotificationType.class);
    private Function<Notification, Notification> notificationModifier = (notification -> notification);
    private Predicate<Notification> notificationFilter = (notification -> true);

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification) {
        notification = notificationModifier.apply(notification);

        if (!notificationFilter.test(notification)) {
            System.out.println("Сообщение не прошло фильтр");
            return;
        }

        Consumer<Notification> handler = notificationHandlers.get(notification.getType());
        handler.accept(notification);
    }
}
