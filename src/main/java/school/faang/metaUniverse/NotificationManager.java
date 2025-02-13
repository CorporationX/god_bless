package school.faang.metaUniverse;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@NonNull
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private Function<Notification, Notification> messageCorrector;
    private Predicate<Notification> filter;

    public NotificationManager() {
        this.filter = notification -> false;
        this.messageCorrector = Function.identity();
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (filter.test(notification)) {
            System.out.println("This message contains bad word");
            return;
        }

        Notification corrected = messageCorrector.apply(notification);
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(corrected);
        } else {
            System.out.println("No handler registered for notification type: " + notification.getType());
        }
    }

    public void filterNotification(Predicate<Notification> filter) {
        this.filter = filter;
    }

    public void messageCorrector(Function<Notification, Notification> messageCorrector) {
        this.messageCorrector = messageCorrector;
    }
}
