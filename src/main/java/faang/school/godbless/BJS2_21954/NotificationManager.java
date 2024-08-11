package faang.school.godbless.BJS2_21954;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public static void registerHandler(String notificationType, Consumer<Notification> notifier){
        notifications.put(notificationType, notifier);
    }

    public static void sendNotification(Notification notification){
        notifications.get(notification.type()).accept(notification);
    }
}
