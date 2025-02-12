package school.faang.sprint2.lambda.metauniversal;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationMap;

    public NotificationManager() {
        notificationMap  = new HashMap<>();
    }

    public void registerHandler(NotificationType notificationType, Consumer<Notification> handler) {
        notificationMap.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        NotificationType notificationType = notification.getNotificationType();
        Consumer<Notification> handler = notificationMap.get(notificationType);
        if (handler != null) {
            notificationMap.get(notificationType).accept(notification);
        } else {
            log.warn("Для уведомления {} не найден обработчик", notificationType);
        }
    }
}
