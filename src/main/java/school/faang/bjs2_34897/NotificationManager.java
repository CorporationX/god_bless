package school.faang.bjs2_34897;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class NotificationManager {

    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    private Predicate<Notification> contentFilter;
    private Function<Notification, Notification> contentTransformer;

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
        System.out.println("Registered for " + notificationType);
    }

    public void registerContentFilter(Predicate<Notification> filter) {
        contentFilter = filter;
    }

    public void sendNotification(Notification notification) {
        if (contentFilter != null && !contentFilter.test(notification)) {
            System.out.println("Notification blocked; " + notification.getMessage());
            return;
        }

        if (contentTransformer != null) {
            notification = contentTransformer.apply(notification);
        }

        Consumer<Notification> handler = handlers.get(notification.getType());

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No one found " + notification.getType());
        }
    }
}







