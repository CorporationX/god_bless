package school.faang.Meta;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.function.Consumer;

@Getter
@AllArgsConstructor
public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers;

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        handlers.get(notification.getType()).accept(notification);
    }

}
