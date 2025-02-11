package school.faang.BJS2_57725;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notificationConsumers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationConsumers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationConsumers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            String.format("Обработчик не зарегистрирован для типа: %s", notification.getType());
        }
    }
}
