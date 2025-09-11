package school.faang.bjs2_91711;

import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationHandlers;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {

    }
    — регистрирует обработчик для определенного типа оповещения.

    sendNotification(Notification notification)
    — вызывает обработчик для переданного типа оповещения.
}
