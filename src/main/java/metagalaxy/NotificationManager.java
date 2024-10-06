package metagalaxy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String name, Consumer<Notification> handler) {
        notifications.put(name, handler);
    }

    public void sendNotification(Notification notification) {
        var handler = notifications.get(notification.getType());

        if (handler == null) {
            throw new IllegalArgumentException("Для уведомления с типом \"" + notification.getType() + "\" не зарегистрирован обработчик");
        }

        handler.accept(notification);
    }
}
