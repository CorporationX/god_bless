package school.faang.bjs2_70675;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@RequiredArgsConstructor
@Data
public class NotificationManager {
    private final Consumer<Notification> defaultNotificationHandler;
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers =
            new EnumMap<>(NotificationType.class);
    @Accessors(fluent = true)
    private UnaryOperator<Notification> registerModifier = (notification -> notification);
    @Accessors(fluent = true)
    private Predicate<Notification> registerFilter = (notification -> true);

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification) {
        notification = registerModifier.apply(notification);

        if (!registerFilter.test(notification)) {
            System.out.println("Сообщение не прошло фильтр");
            return;
        }

        Consumer<Notification> handler = notificationHandlers.getOrDefault(
                notification.getType(), defaultNotificationHandler
        );
        handler.accept(notification);
    }
}
