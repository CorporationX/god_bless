package faang.school.godbless.functionalInterfaces.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;


public class NotificationManager {
    public final Map<String, Function<Notification, String>> notificationHandlers = new HashMap<>();

    public boolean registerHandler(String notificationType, Function<Notification, String> handler) {
        if (notificationType == null || notificationType.isBlank()) {
            System.out.println("Notification type can't be null or blank!");

            return false;
        }

        if (handler == null) {
            System.out.println("Handler can't be null!");

            return false;
        }

        notificationHandlers.put(notificationType, handler);
        System.out.println("Notification handler was successfully assigned to " + notificationType + " notifications.");

        return true;
    }

    public String sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Null-valued notification cannot be processed");
        }

        if(!notificationHandlers.containsKey(notification.type())) {
            throw new NoSuchElementException("No such notification type in system!");
        }

        return notificationHandlers.get(notification.type()).apply(notification);
    }
}
