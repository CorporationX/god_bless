package school.faang.bjs2_70527;

import static school.faang.bjs2_70527.NotificationType.EMAIL;
import static school.faang.bjs2_70527.NotificationType.PUSH;
import static school.faang.bjs2_70527.NotificationType.SMS;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(EMAIL,
                notification -> System.out.println("Email: " + notification.message())
        );

        notificationManager.registerHandler(SMS,
                notification -> System.out.println("SMS: " + notification.message())
        );

        notificationManager.registerHandler(PUSH,
                notification -> System.out.println("Push Notification: " + notification.message())
        );

        Notification emailNotification = new Notification(EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
