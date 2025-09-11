package school.faang.meta.universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> notificationManager = new HashMap<>();

    void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationManager.put(type, handler);
        System.out.println("[+] Зарегистрирован новый обработчик - " + type);
    }

    void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationManager.get(notification.type());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("[-] Для типа " + notification.type() + " обработчик не найден");
        }
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.println("Email: " + notification.message())
        );
        notificationManager.registerHandler(NotificationType.SMS, notification ->
                System.out.println("SMS: " + notification.message())
        );
        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                System.out.println("Push Notification: " + notification.message())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
