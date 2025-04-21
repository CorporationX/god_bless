package school.faang.bjs2_70670;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    private final Function<Notification, Notification> applySignature = notification ->
            new Notification(notification.getType(), notification.getMessage() + " | @JegorKuz");

    private final Predicate<Notification> wrongNotification = notification ->
            notification.getType() == NotificationType.EMAIL;

    private final BiFunction<Notification, Predicate<Notification>, Notification> exceptionNotification =
            (notification, isEmail) -> {
                if (isEmail.test(notification)) {
                    return new Notification(notification.getType(), "currently not supported");
                }
                return notification;
            };

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Notification notificationWithSignature = applySignature.apply(notification);
        Notification checkedForExceptionNotification =
                exceptionNotification.apply(notificationWithSignature, wrongNotification);
        Consumer<Notification> notificationConsumer = notifications.get(checkedForExceptionNotification.getType());
        notificationConsumer.accept(checkedForExceptionNotification);
    }
}
