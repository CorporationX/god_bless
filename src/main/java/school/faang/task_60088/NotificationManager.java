package school.faang.task_60088;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlersByType;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlersByType.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> printer = n -> System.out.println(notification.getMessage());
        printer.accept(notification);
    }

}
