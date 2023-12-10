package faang.school.godbless.lambda.task2metaspace;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        String notificationType = notification.getType();
        if (handlers.containsKey(notificationType)) {
            handlers.get(notificationType).accept(notification);
        } else {
            System.out.println("Для типа уведомления не зарегистрирован обработчик: " + notificationType);
        }
    }
}