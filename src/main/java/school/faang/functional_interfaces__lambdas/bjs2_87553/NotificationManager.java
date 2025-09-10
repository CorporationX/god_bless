package school.faang.functional_interfaces__lambdas.bjs2_87553;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notifications.containsKey(notification.getType())) {
            notifications.get(notification.type).accept(notification);
        } else {
            System.out.println("Некорректный запрос.");
        }
    }
}
