package faang.school.godbless.sprint3.metaverse;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.function.Function;

@NoArgsConstructor
public class NotificationManager {
    private HashMap<NotificationType, Function<Notification, String>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType notificationId, Function<Notification, String> handler) {
        notificationHandlers.put(notificationId, handler);
    }

    public String sendNotification(Notification notification) {
        Function<Notification, String> handler = notificationHandlers.get(notification.getType());
        if (handler != null) {
            return handler.apply(notification);
        }
        return "Failed to send notification";
    }
}
