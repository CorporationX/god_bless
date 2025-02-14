package school.faang.task_57880;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(
            NotificationType type,
            Consumer<Notification> handler) {

        notificationMap.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification) {
        notificationMap.getOrDefault(
                notification.getType(),
                n -> log.info("Нет подходящего типа уведомления!")
        ).accept(notification);
    }
}
