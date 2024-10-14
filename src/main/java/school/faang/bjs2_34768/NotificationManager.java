package school.faang.bjs2_34768;

import lombok.Getter;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Log
@Getter
public class NotificationManager {
    private final Map<Notification.TypeOfNotification, Consumer<Notification>> notificationHandler = new HashMap<>();
    private final Map<Notification.TypeOfNotification, Predicate<Notification>> notificationFilter = new HashMap<>();

    public void registerHandler(Notification.TypeOfNotification type, Consumer<Notification> notification) {
        notificationHandler.put(type, notification);
    }

    public void sendNotification(Notification notification) {
       notificationHandler.get(notification.getType()).accept(notification);
    }

    public void registerFilter(Notification.TypeOfNotification type, Predicate<Notification> notification) {
        notificationFilter.put(type, notification);
    }
    public void isNotificationContainsCensorship(Notification notification) {
        boolean isCensor = notificationFilter.get(notification.getType()).test(notification);
        if (isCensor) {
            log.warning("Notification contains censorship. Sending prohibited!");
        } else {
            log.info("The notice does not contain censorship. Let's pass");
        }
    }
}
