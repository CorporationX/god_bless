package meta_universe;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.function.Consumer;

@Getter
@AllArgsConstructor
public class NotificationManager {
    private final Map<String, Consumer<Notification>> HANDLERS;

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        HANDLERS.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        HANDLERS.get(notification.getType()).accept(notification);
    }
}
