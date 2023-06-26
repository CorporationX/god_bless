package faang.school.godbless.metaspace;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationHandler;

    public NotificationManager() {
        notificationHandler = new HashMap<>();
    }

    public void registerHandler(String notificationId, Consumer<Notification> handler) {
        if (notificationId == null ||notificationId.isBlank()) {
            throw new IllegalArgumentException("NotificationId is blank or null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Handler is null");
        }
        notificationHandler.put(notificationId, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            return;
        }
        String typeNotification = notification.getType();
        if (notificationHandler.containsKey(typeNotification)) {
            notificationHandler.get(typeNotification).accept(notification);
        } else {
            System.out.println("Нет обработчика для данного типа уведомления.");
        }
    }
}
