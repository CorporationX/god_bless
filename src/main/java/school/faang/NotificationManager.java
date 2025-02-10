package school.faang;

import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private Map<NotificationType, Consumer<Notification>> notifications;
    //обработчик оповещений

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
        System.out.println("Registered handler for " + type + ": " + handler);
    }

    //отправитель оповещений
    public void sendNotification(Notification notification) {

    }

}

