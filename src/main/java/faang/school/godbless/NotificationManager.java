package faang.school.godbless;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public class NotificationManager {
    private Map<String, Consumer<Notification>> msgStorage = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notification) {
        msgStorage.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        msgStorage.get(notification.getType()).accept(notification);
    }
}
