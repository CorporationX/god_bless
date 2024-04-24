package faang.school.godbless.Lambdas.MetaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public final Map<String, Consumer<Notification>> NOTIFICATION_HANDLERS = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        try {
            if (handler != null && type != null) {
                NOTIFICATION_HANDLERS.put(type, handler);
            } else {
                throw new IllegalArgumentException("type or consumer is null");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при регистраци обработчика уведомлений: " + e.getMessage());
        }
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = NOTIFICATION_HANDLERS.get(notification.getType());
        if (consumer != null) {
            consumer.accept(notification);
        } else {
            System.out.println("Не найден обработчик для типа уведомления: " + notification.getType());
        }
    }
}
