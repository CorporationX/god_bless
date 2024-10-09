package school.faang.meta_universe_BJS2_34638;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationsImplementations = new HashMap<>();
    private Map<String, Consumer<Notification>> inappropriateContent = new HashMap<>();

    public void registerHandler(String notification, Consumer<Notification> implementation,
                                Map<String, Consumer<Notification>> targetMap) {
        targetMap.put(notification, implementation);
    }

    public void sendNotification(Notification notification) {
        if (!notificationsImplementations.containsKey(notification.getType())) {
            System.out.println("No implementation for " + notification.getType() + " notification");
        } else {
            notificationsImplementations.get(notification.getType()).accept(notification);
        }
    }

    public void blockInappropriateContent(Notification notification) {
        if (!inappropriateContent.containsKey(notification.getType())) {
            System.out.println("This  type of notification: '" + notification.getType() + "' is not blocked");
        } else {
            inappropriateContent.get(notification.getType()).accept(notification);
        }
    }
}