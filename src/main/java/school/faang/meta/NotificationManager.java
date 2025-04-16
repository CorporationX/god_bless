package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@AllArgsConstructor
@Getter
@Setter
public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> typeConsumerMap = new HashMap<>();

    private final List<String> badString = List.of("плохо", "нельзя такое");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        typeConsumerMap.put(type, handler);
    }

    public Predicate<String> isCensure() {
        return message -> badString.stream().anyMatch(message::contains);
    }

    public String sendNotification(Notification notification) {
        if (isCensure().test(notification.getMessage())) {
            return "Не использовать цензуру";
        } else {
            return "Сообщение отправлено %s".formatted(notification.getNotificationType());
        }
    }
}
