package school.faang.meta_universe;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    @Setter
    private Predicate<Notification> filter = n -> true;
    @Setter
    private Function<Notification, Notification> corrector = Function.identity();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
        System.out.println(type);
    }

    //вызывает обработчик для переданного типа оповещения.
    public void sendNotification(Notification notification) {
        if (!filter.test(notification)) {
            System.out.println("Notification blocked by filter" + notification);
            return;
        }
        Notification correctedNotification = corrector.apply(notification);

        Consumer<Notification> handler = handlers.get(correctedNotification.type());
        if (handler == null) {
            System.out.println("No handler register for type" + correctedNotification.type());
            return;
        }
        handler.accept(correctedNotification);
    }
}


