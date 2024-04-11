package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.registerHandler("email", (notification) ->
                System.out.println(notification.getMessage()));
        manager.registerHandler("sms", (notification) ->
                System.out.println(notification.getMessage()));
        manager.registerHandler("push", (notification) ->
                System.out.println(notification.getMessage()));
        Notification emailNotification = new Notification("email", "Новове сообщение на почте");
        Notification smsNotification = new Notification("sms", "Новое sms");
        Notification spamNotification = new Notification("spam", "Пришло спам сообщение");
        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(spamNotification);
    }

    private void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    private void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Для уведомления " + notification.getType() + " нет обработчика");
        }
    }
}

