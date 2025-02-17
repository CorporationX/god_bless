package school.faang.task_59812;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Setter
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private Predicate<Notification> filter = notification -> true;
    private Function<Notification, Notification> corrector = notification -> notification;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (filter.test(notification)) {
            Notification correctedNotification = corrector.apply(notification);
            Consumer<Notification> handler = handlers.get(correctedNotification.type());

            handler.accept(correctedNotification);
        } else {
            System.out.println("Уведомление заблокировано. Содержит нецензурные выражения");
        }
    }
}
