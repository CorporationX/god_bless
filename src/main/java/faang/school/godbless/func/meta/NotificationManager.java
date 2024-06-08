package faang.school.godbless.func.meta;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@NoArgsConstructor
public class NotificationManager {

    private final Map<String, Consumer<Notification>> plainNotifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        this.plainNotifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        plainNotifications.get(notification.type()).accept(notification);
    }
}
