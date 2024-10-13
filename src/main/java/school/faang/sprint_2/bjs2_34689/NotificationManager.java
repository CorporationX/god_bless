package school.faang.sprint_2.bjs2_34689;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> HANDLERS = new HashMap<>();
    private static final String REGEX_FOR_CENSOR = "(?i)(ass|idiot|dumb)";

    public void registerHandler(String notificationType, Consumer<Notification> notificationConsumer) {
        HANDLERS.put(notificationType, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        if (HANDLERS.containsKey(type)) {
            censorNotification(notification);
            Consumer<Notification> handler = HANDLERS.get(type);
            handler.accept(notification);
        } else {
            System.out.println("Обработчик для сообщений такого типа отсутствует.");
        }
    }

    private void censorNotification(Notification notification) {
        String message = notification.getMessage();
        String censoredMessage = message.replaceAll(REGEX_FOR_CENSOR, "***");
        notification.setMessage(censoredMessage);
    }
}