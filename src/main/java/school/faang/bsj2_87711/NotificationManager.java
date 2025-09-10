package school.faang.bsj2_87711;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@AllArgsConstructor
@NoArgsConstructor
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> notificationConsumer) {
        notificationHandlers.putIfAbsent(type, notificationConsumer);
    }

    public void sendNotification(Predicate<Notification> notificationPredicate, Notification notification) {
        if (notificationPredicate.test(notification) && notificationHandlers.get(notification.getType()) != null) {
            notificationHandlers.get(notification.getType()).accept(notification);
        } else if (!notificationPredicate.test(notification)) {
            System.out.println("Слишком много символов: " +
                    notification.getMessage().length() + " > " +
                    Notification.MAX_NOTIFICATION_LENGTH);
        } else {
            System.out.println("Не знаем как доставить уведомление");
        }
    }
}
