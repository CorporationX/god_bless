package bjs291768;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();
    private final List<Predicate<Notification>> notificationFilters = new ArrayList<>();
    private final List<Function<Notification, Notification>> notificationEditors = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.putIfAbsent(type, handler);
    }

    public void registerFilter(Predicate<Notification> filter) {
        notificationFilters.add(filter);
    }

    public void registerEditor(Function<Notification, Notification> editor) {
        notificationEditors.add(editor);
    }

    public void sendNotification(Notification notification) {
        for (Predicate<Notification> filter : notificationFilters) {
            if (!filter.test(notification)) {
                System.out.println("Notification blocked: " + notification);
                return;
            }
        }

        for (Function<Notification, Notification> editor : notificationEditors) {
            notification = editor.apply(notification);
        }

        Consumer<Notification> handler = notificationHandlers.get(notification.type());
        if (handler == null) {
            System.out.println("No handler registered for " + notification.type());
        } else {
            handler.accept(notification);
        }
    }
}
