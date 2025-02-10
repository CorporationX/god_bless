package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();
    //обработчик оповещений

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
        System.out.println("Registered handler for " + type.getNotificationName() + ": " + handler);

    }

    //отправитель оповещений
    public void sendNotification(Notification notification) {
        notifications.get(notification.getType()).accept(notification);
    }

    public void notificationWithFunction(NotificationType type, Notification notification) {

    }

}

