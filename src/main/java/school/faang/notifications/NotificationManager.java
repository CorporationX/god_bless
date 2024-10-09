package school.faang.notifications;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationsHandlers = new HashMap<>();
    private final Map<String, Predicate<String>> filters = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> correctiveNotificationsHandlers = new HashMap<>();

    public void registerNotificationHandler(String type, Consumer<Notification> consumer) {
        notificationsHandlers.put(type, consumer);
    }

    public void registerFilter(String type, Predicate<String> predicate) {
        filters.put(type, predicate);
    }

    public void registerCorrectiveNotificationsHandlers(String type, Function<Notification, Notification> function) {
        correctiveNotificationsHandlers.put(type, function);
    }

    public void sendNotification(Notification notification) {
        Predicate<String> filter = filters.get(notification.getType());

        if(filter != null && filter.test(notification.getMessage().toLowerCase())) {
            var correctiveNotificationHandler =  correctiveNotificationsHandlers.get(notification.getType());

            if(correctiveNotificationHandler != null) {
                notification = correctiveNotificationHandler.apply(notification);
            }else {
                System.out.println("уведмеление типа " + notification.getType() + " не прошло проверку на неприемлемый контент");
                return;
            }
        }

        Consumer<Notification> handler = notificationsHandlers.get(notification.getType());

        if(handler != null) {
            handler.accept(notification);
        }
    }
}
