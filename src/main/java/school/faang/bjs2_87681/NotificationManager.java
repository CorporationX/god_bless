package school.faang.bjs2_87681;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;


//todo убрать неиспользуемые аннотации
@ToString
@Getter
@EqualsAndHashCode
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationTypeConsumerMap = new HashMap<>();
    /*
todo Не очень информативное имя переменной(line 18),
 лучше давать имена ближе к объектной области - здесь хранятся обработчики сообщений,
  вот и назвать её лучше чем-то вроде handlers, notificationHandlers или handlersMap
*/
    private final Predicate<String> containBadWord = s -> s.contains("оскорбление");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationTypeConsumerMap.put(type, handler);
    }

    @NonNull
    public void sendNotification(Notification notification) {
        Objects.requireNonNull(notification, "Notification cannot be null");

        validateBadWords(notification, containBadWord);
        notificationTypeConsumerMap.get(notification.getType()).accept(notification);
    }

    public void validateBadWords(Notification notification, Predicate<String> filter) {
        if (filter.test(notification.getMessage())) {
            throw new IllegalArgumentException("Переданное сообщение содержит оскорбления");
        }
    }
}
