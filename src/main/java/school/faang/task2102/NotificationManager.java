package school.faang.task2102;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<String, Function<Notification,Notification>> filters = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler){
        handlers.put(notificationType, handler);
    }

    public void registerFilter(String notificationType, Function<Notification,Notification> filter){
        filters.put(notificationType, filter);
    }

    public void sendNotification(Notification notification){
        if (notification == null) {
            System.out.println("Notification cannot be null");
            return;
        }

        //TODO: IDEA ругается "Reassigned parameter" на notification. Как делать правильно?
        Function<Notification, Notification> filter = filters.get(notification.getType());
        if (filter != null) {
            notification = filter.apply(notification);
        }

        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler found for notification type: " + notification.getType());
        }
    }
}
