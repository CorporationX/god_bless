package school.faang.bjs2_80655;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationTypeConsumer = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationTypeConsumer.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationTypeConsumer.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.printf("обработчик для %s отсутсвует", notification.getType());
        }
    }
}