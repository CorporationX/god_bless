package school.faang.bjs2_71899;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@AllArgsConstructor
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        try {
            notificationHandlers.get(notification.getType()).accept(notification);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
