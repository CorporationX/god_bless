package school.faang.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler registered for " + notification.getType());
        }
    }

    public void sendFilteredNotification(Notification notification, Predicate<String> filter,
                                         Function<String, String> corrector) {
        if (filter.test(notification.getMessage())) {
            String correctedMessage = corrector.apply(notification.getMessage());
            Notification correctedNotification = new Notification(notification.getType(), correctedMessage);
            sendNotification(correctedNotification);
        } else {
            sendNotification(notification);
        }
    }
}
