package meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationTypes = new HashMap<>();
    private final Map<String, Predicate<Notification>> notificationLengthChecks = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        if (notificationType == null || notificationType.isBlank()) {
            throw new IllegalArgumentException("Was got empty String class");
        }
        notificationTypes.put(notificationType, handler);
    }

    public void registerNotificationLengthChecks(String notificationType, Predicate<Notification> checker) {
        if (!notificationTypes.containsKey(notificationType)) {
            throw new IllegalArgumentException("The transferred type does not exist in the system");
        }
        notificationLengthChecks.put(notificationType, checker);
    }

    public void sendNotification(Notification notification) {
        if (!notificationTypes.containsKey(notification.getType())) {
            throw new IllegalArgumentException("The transferred type does not exist in the system");
        }
        checkLengthOfNotification(notification);

        notificationTypes.get(notification.getType())
                .accept(notification);
    }

    private void checkLengthOfNotification(Notification notification) {
        if (!notificationLengthChecks.containsKey(notification.getType())) {
            return;
        }

        Predicate<Notification> checker = notificationLengthChecks.get(notification.getType());
        if (!checker.test(notification)) {
            throw new IllegalArgumentException("The length of the notification message is exceeded");
        }
    }
}
