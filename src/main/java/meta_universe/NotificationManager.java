package meta_universe;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.function.Consumer;

@Getter
@AllArgsConstructor
public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers;

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        handlers.get(notification.getType()).accept(notification);
    }
}
