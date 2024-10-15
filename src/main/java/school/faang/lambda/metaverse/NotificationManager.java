package school.faang.lambda.metaverse;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

   private static final Map<String, Consumer<Notification>> NOTIFICATION_HANDLERS = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {

        NOTIFICATION_HANDLERS.put(notificationType, handler);

    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = NOTIFICATION_HANDLERS.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для типа оповещения: " + notification.getType());
        }
    }
}

