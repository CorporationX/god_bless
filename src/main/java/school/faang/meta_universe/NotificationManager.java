package school.faang.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notificationMap = new HashMap<>();

    public static final String MESSAGE_WAS_SENT = "Сообщение \"%s\" отправлено с помощью %s";

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        notificationMap.get(notification.getType()).accept(notification);
        System.out.println(String.format(MESSAGE_WAS_SENT, notification.getMessage(), notification.getType()));
    }
}
