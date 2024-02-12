package faang.school.godbless.lambda.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> notificationMap = new HashMap<>();
    public void registerHandler(String notification, Consumer<Notification> consumer){
        notificationMap.put(notification, consumer);
    }

    public void sendNotification(Notification notification){
        String notificationType = notification.getType();
        Consumer<Notification> type = notificationMap.get(notificationType);
        type.accept(notification);
    }
}
