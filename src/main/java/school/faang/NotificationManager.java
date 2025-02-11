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

    public void notificationWithDescription(Notification userNotification) {
        switch (userNotification.getType()) {
            case SMS -> {
                String description = " send by SMS";
                sendNotification(userNotification);
                System.out.println(description);
            }

            case EMAIL -> {
                String description = " send by EMAIL";
                sendNotification(userNotification);
                System.out.println(description);
            }
            case PUSH -> {
                String description = " send by PUSH";
                sendNotification(userNotification);
                System.out.println(description);
            }
            default -> {
                String description = " unknown notification type: " + userNotification.getType();
                System.out.println("Notification don`t send | " + description);
            }
        }
    }

}

