package school.faang.bjs2_71899;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@Getter
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (handler == null) {
            log.error("Обработчик сообщения не может быть равен нулю. Регистрация обработчика отменена.");
            return;
        }
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Сообщдение пустое. Отправка не будет сделана.");
        }

        Consumer<Notification> consumer = notificationHandlers.get(notification.getType());
        if (consumer == null) {
            log.error("Не найден обработчик для текущего метода отправки. Зарегистирруйте новый обработчик.");
            return;
        }
        consumer.accept(notification);
    }
}
