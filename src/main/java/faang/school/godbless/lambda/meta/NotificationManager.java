package faang.school.godbless.lambda.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();
    public void registerHandler(String notification, Consumer<Notification> handler){
        notificationHandlers.put(notification, handler);
    }

    public void sendNotification(Notification notification){
        String notificationType = notification.getType();
        Consumer<Notification> handler = notificationHandlers.get(notificationType);
        handler.accept(notification);
    }
}
