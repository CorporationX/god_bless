package school.faang.bjs2_71899;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@Getter
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationHandlers;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (notificationHandlers == null) {
            notificationHandlers = new HashMap<>();
        }
        if (handler == null) {
            log.error("Обработчик сообщения не может быть равен нулю. Регистрация обработчика отменена.");
            return;
        }
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            log.error("Сообдение пустое. Отправка не будет сделана.");
            return;
        }
        if (notificationHandlers.get(notification.getType()) == null) {
            log.error("Не найден обработчик для текущего метода отправки. Зарегистирруйте новый обработчик.");
            return;
        }
        notificationHandlers.get(notification.getType()).accept(notification);
    }
}
