package school.faang.universe;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlersMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlersMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (handlersMap.containsKey(notification.getType())) {
            handlersMap.get(notification.getType()).accept(notification);
        } else {
            log.info("Обработчик данного типа не был найден");
        }
    }
}
