package school.faang.task_60088;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlersByType;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlersByType.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notificationHandlersByType.containsKey(notification.getType())) {
            Consumer<Notification> printer = n -> System.out.println(notification.getMessage());
            printer.accept(notification);
        } else {
            log.info("This notification type is not registered.");
        }
    }

}
