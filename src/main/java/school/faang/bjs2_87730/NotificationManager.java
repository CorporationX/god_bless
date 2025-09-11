package school.faang.bjs2_87730;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notificationHandlers.get(notification.getType()) != null) {
            notificationHandlers.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Обработчик для полученного типа оповещения не зарегистрирован");
        }
    }

    public Notification addDateToNotificationMessage(Notification notification,
                                          Function<Notification, Notification> changer) {
        return changer.apply(notification);
    }
}
