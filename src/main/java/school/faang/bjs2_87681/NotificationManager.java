package school.faang.bjs2_87681;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@ToString
@Getter
@EqualsAndHashCode
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationTypeConsumerMap = new HashMap<>();
    private final Predicate<String> containBadWord = s -> s.contains("оскорбление");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationTypeConsumerMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("null передан как объект Notification");
        }
        if (notification.getMessage() == null) { // в итоге кажется что эта проверка и не нужна
            throw new IllegalArgumentException("message объекта равен null");
        }

        isContainsBadWords(notification, containBadWord);
        notificationTypeConsumerMap.get(notification.getType()).accept(notification);
    }

    public void isContainsBadWords(Notification notification, Predicate<String> filter) {
        if (filter.test(notification.getMessage())) {
            System.out.println("Сообщение содержит оскорбления");
        } else {
            System.out.println("Сообщение не содержит оскорблений");
        }
    }
}
