package school.faang.BJS2_80711;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers;
    @Setter
    private Predicate<Notification> filter = notification -> true;
    @Setter
    private Function<Notification, Notification> messageCorrector = Function.identity();

    public NotificationManager() {
        this.handlers = new HashMap<>();
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (!filter.test(notification)) {
            System.out.println("Сообщение заблокировано фильтром: " + notification.getMessage());
            return;
        }

        Notification corrected = messageCorrector.apply(notification);
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(corrected);
        } else {
            System.out.println("No handler registered for " + notification.getType());
        }
    }
}
