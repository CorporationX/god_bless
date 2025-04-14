package meta.universe;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Getter
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notifyAndHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (Objects.isNull(type) || Objects.isNull(handler)) {
            throw new IllegalArgumentException("Please use non null parameters!");
        }
        this.notifyAndHandlers.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification, Predicate<Notification> predicate) {
        if (Objects.isNull(notification)) {
            throw new IllegalArgumentException("Please use non null parameter!");
        } else if (predicate.test(notification)) {
            notification.setMessage("This message violates our app policy!");
        }
        this.notifyAndHandlers.get(notification.getType()).accept(notification);
    }
}
