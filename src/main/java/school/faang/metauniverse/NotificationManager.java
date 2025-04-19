package school.faang.metauniverse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationByType = new HashMap<>();
    private Predicate<Notification> filter;
    private Function<Notification, Notification> corrector;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationByType.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Notification correctedNotification;
        if (corrector != null) {
            correctedNotification = corrector.apply(notification);
        } else {
            correctedNotification = notification;
        }

        if (filter != null && !filter.test(correctedNotification)) {
            System.out.println(" -Сообщение заблокировано фильтром: ");
            return;
        }

        Consumer<Notification> handler = notificationByType.get(correctedNotification.getType());
        if (handler != null) {
            handler.accept(correctedNotification);
        }
    }
}
