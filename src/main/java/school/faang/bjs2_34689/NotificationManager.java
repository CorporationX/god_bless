package school.faang.bjs2_34689;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> HANDLERS = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationConsumer) {
        HANDLERS.put(notificationType, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        if (!HANDLERS.containsKey(type)) {
            checkHandler(notification);
        }
        Consumer<Notification> handler = HANDLERS.get(type);
        handler.accept(notification);
    }

    private void checkHandler(Notification notification) {
        String type = notification.getType();
        String message = notification.getMessage();
        if (!HANDLERS.containsKey(type)) {
            registerHandler(type, (newNotification) ->
                    System.out.println("Получено сообщение нового типа '" + type + "': " + message));
        }
    }
}
