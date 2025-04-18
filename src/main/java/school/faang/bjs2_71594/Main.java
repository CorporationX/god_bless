package school.faang.bjs2_71594;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Consumer<Notification> smsConsumer = notification -> System.out.println("SMS: " + notification.getMessage());
        Consumer<Notification> emailConsumer = notification -> System.out.println("Email: " + notification.getMessage() + "@meta.com");
        Consumer<Notification> pushConsumer = notification -> System.out.println("Push notification: " + notification.getMessage());

        notificationManager.registerHandler(NotificationType.SMS, smsConsumer);
        notificationManager.registerHandler(NotificationType.EMAIL, emailConsumer);
        notificationManager.registerHandler(NotificationType.PUSH, pushConsumer);

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
