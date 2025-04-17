package school.faang.meta;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        notificationManager.addFilter(notification -> notification.getMessage().contains("Кек"));
        notificationManager.addFilter(notification -> notification.getMessage().contains("Лол"));

        notificationManager.addHeader(notification -> {
            notification.setMessage(notification.getMessage() + "\nС уважением, Мета\n");
            return notification;
        });

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Вам пришло сообщение с ");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification pushNotification2 = new Notification(NotificationType.PUSH, "Лол Кек");
        Notification pushNotification3 = new Notification(NotificationType.PUSH, "Привет, Лол");
        Notification smsNotification2 = new Notification(NotificationType.SMS, "Это спам, Кек");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(pushNotification2);
        notificationManager.sendNotification(pushNotification3);
        notificationManager.sendNotification(smsNotification2);
    }
}