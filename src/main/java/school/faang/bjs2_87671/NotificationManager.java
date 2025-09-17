package school.faang.bjs2_87671;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handlerToRun = notificationHandlers.get(notification.getType());
        if (handlerToRun != null) {
            handlerToRun.accept(notification);
        }
    }
}
