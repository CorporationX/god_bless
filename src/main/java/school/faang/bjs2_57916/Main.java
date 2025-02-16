package school.faang.bjs2_57916;

import static school.faang.bjs2_57916.NotificationType.EMAIL;
import static school.faang.bjs2_57916.NotificationType.PUSH;
import static school.faang.bjs2_57916.NotificationType.SMS;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));

        notificationManager.registerHandler(EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );


        Notification emailNotification = new Notification(EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
