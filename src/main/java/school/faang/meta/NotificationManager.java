package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private Function<Notification, Notification> corrector = n -> n;
    private Predicate<Notification> filter = n -> true;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void setFilter(Predicate<Notification> filter) {
        this.filter = filter;
    }

    public void setCorrector(Function<Notification, Notification> corrector) {
        this.corrector = corrector;
    }

    public void sendNotification(Notification notification) {
        Notification correctedNotification = corrector.apply(notification);
        Consumer<Notification> handler = handlers.get(correctedNotification.getType());
        if (!filter.test(notification)) {
            System.out.println("Уведомление заблокировано: " + notification.getMessage());
            return;
        }
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для типа: " + notification.getType());
        }
    }
}
