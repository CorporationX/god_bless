package task_BJS2_57697;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@Data
@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        try {
            Notification notification = new Notification(type, "");
            handler.accept(notification);
            notifications.put(type, handler);
        } catch (NullPointerException exception) {
            log.error("Попытка передать null в параметры метода registerHandler: ", exception);
        }
    }

    public void sendNotification(Notification notification) {
        try {
            if (!notifications.containsKey(notification.getType())) {
                notifications.put(notification.getType(), handler -> System.out.printf("%s\n",
                        notification.getMessage()));
            }
            registerHandler(notification.getType(), handler -> System.out.printf("%s\n", notification.getMessage()));
        } catch (NullPointerException exception) {
            log.error("Попытка передать null в параметры метода sendNotification: ", exception);
        }
    }

    public void addSignature(Notification notification, Function<Notification, Notification> function) {
        try {
            function.apply(notification);
        } catch (NullPointerException exception) {
            log.error("Попытка передать null в параметры метода sendNotification: ", exception);
        }
    }

    public Notification putSignature(Notification notification) {
        notification.setMessage(notification.getMessage() + Notification.signature);
        return notification;
    }
}
