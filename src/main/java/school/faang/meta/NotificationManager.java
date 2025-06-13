package school.faang.meta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notificationTypeConsumerMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> consumer) {
        notificationTypeConsumerMap.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = notificationTypeConsumerMap.get(notification.getNotificationType());
        if (consumer != null) {
            consumer.accept(notification);
        } else {
            System.out.println("Тип оповещения " + notification.getNotificationType() + " не найден!");
        }
    }

    public boolean filterNotification(Notification notification, Predicate<Notification> predicate) {
        return !predicate.test(notification);
    }

    public Function<Notification, Notification> addTextToNotification(Notification incNotification) {
        return notification ->
                    new Notification(
                        incNotification.getNotificationType(),
                        incNotification.getMessage() + " с уважением от FAANG SCHOOL"
                );
    }

}