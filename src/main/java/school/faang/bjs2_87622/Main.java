package school.faang.bjs2_87622;

import static school.faang.bjs2_87622.Notification.NotificationType.EMAIL;
import static school.faang.bjs2_87622.Notification.NotificationType.SMS;
import static school.faang.bjs2_87622.Notification.NotificationType.PUSH;

public class Main {
    public static void main(String[] args) {
        NotificationManager.registerNotificationHandler(EMAIL,
                (notification) -> System.out.println("Email: " + notification.message()));

        NotificationManager.registerNotificationHandler(SMS,
                (notification) -> System.out.println("SMS notification: " + notification.message()));

        NotificationManager.registerNotificationHandler(PUSH,
                (notification) -> System.out.println("PUSH notification " + notification.message()));


        Notification emailType = new Notification(EMAIL, "Premium статус был активирован");
        NotificationManager.sendNotification(emailType);

        Notification smsType = new Notification(SMS, "Ваш код: 962744");
        NotificationManager.sendNotification(smsType);

        Notification pushType = new Notification(PUSH, "Встреча состоится в ресторане Яръ");
        NotificationManager.sendNotification(pushType);
    }
}