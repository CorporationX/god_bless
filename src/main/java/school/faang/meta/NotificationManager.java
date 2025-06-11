package school.faang.meta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notificationTypeConsumerMap = new HashMap<>();

    private final List<String> badWordList = List.of("срань", "какаха", "жупел");

    public void registerHandler(NotificationType type, Consumer<Notification> consumer) {
        notificationTypeConsumerMap.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        System.out.println(notification);
    }

    public void filterNotification(Notification notification, Predicate<Notification> predicate) {
        predicate.test(notification);
    }

    public Function<Notification, Notification> addTextToNotification(String text) {
        return notification ->
                new Notification(
                        notification.getNotificationType(),
                        notification.getMessage() + " " + text
                );
    }

}
