package gratsio_bjs2_70575;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    Predicate<Notification> filter = notification -> true;
    Function<Notification, Notification> messageCorrector = notification -> notification;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.handlers.put(type, handler);
    }

    public void addFilter(Predicate<Notification> filter) {
        this.filter = filter;
    }

    public void addMessageCorrector(Function<Notification, Notification> corrector) {
        this.messageCorrector = corrector;
    }

    public void sendNotification(Notification notification) {
        if (filter.test(notification)) {
            Consumer<Notification> handler = this.handlers.get(notification.getType());
            if (handler != null) {
                Notification correctNotification = messageCorrector.apply(notification);
                handler.accept(correctNotification);
            } else {
                System.out.println("No handler registered for " + notification.getType());
            }
        } else {
            System.out.println("The alert contains profanity!");
        }
    }
}
