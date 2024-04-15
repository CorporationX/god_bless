package faang.school.godbless.metauniverse;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Consumer;

@Data
@RequiredArgsConstructor
public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationToHandler;

    public void registerHandler(String type, Consumer<Notification> handler) {
        notificationToHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationToHandler.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        }
    }
}
