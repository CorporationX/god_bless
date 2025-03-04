package school.faang.meta_universee;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<Notification.NotificationType, Consumer<Notification>> idHandlerMap = new HashMap<>();

    public void registerHandler(Notification.NotificationType type, Consumer<Notification> handler) {
        this.idHandlerMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        //вызывает обработчик
        idHandlerMap.get(notification.getType()).accept(notification);
    }

    public String filterNotification(Notification notification) {
        if (notification.getMessage().contains(""))
    }
}
