package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationsHandlers = new HashMap<>();
    public void registerHandler(String id, Consumer<Notification> notificationHandler){
        notificationsHandlers.put(id, notificationHandler);
    }
    public void sendNotification(Notification notification){
        Consumer<Notification> handler = notificationsHandlers.get(notification.getType());

        if (handler!=null){
            handler.accept(notification);
        }
        else {
            throw new IllegalArgumentException("This type of notification doesn't exist");
        }
    }
}
