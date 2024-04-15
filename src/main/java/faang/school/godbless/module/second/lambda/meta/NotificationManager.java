package faang.school.godbless.module.second.lambda.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final String NOT_REGISTERED_NOTIFICATION_TYPE = "NOT_REGISTERED";
    private static final Map<String, Consumer<Notification>> NOTIFICATION_TYPE_TO_HANDLER = new HashMap<>();
    
    static {
        NOTIFICATION_TYPE_TO_HANDLER.put(
            NOT_REGISTERED_NOTIFICATION_TYPE,
            (notification) -> System.out.printf("Type %s not registered \n", notification.getType())
        );
    }
    
    public static void registerHandler(String notificationId, Consumer<Notification> action) {
        NOTIFICATION_TYPE_TO_HANDLER.put(notificationId, action);
    }
    
    public static void sendNotification(Notification notification) {
        Consumer<Notification> action = NOTIFICATION_TYPE_TO_HANDLER.getOrDefault(
            notification.getType(),
            NOTIFICATION_TYPE_TO_HANDLER.get(NOT_REGISTERED_NOTIFICATION_TYPE)
        );
        action.accept(notification);
    }
}
