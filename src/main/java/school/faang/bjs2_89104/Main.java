package school.faang.bjs2_89104;

import static school.faang.bjs2_89104.Notification.NotificationType.SMS;
import static school.faang.bjs2_89104.Notification.NotificationType.PUSH;
import static school.faang.bjs2_89104.Notification.NotificationType.EMAIL;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(SMS, notification -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(PUSH, notification -> System.out.println("PUSH: " + notification.getMessage()));
        notificationManager.registerHandler(EMAIL, notification -> System.out.println("EMAIL: " + notification.getMessage()));

        Notification emailNotification = new Notification(EMAIL, "Your account is activated");
        Notification smsNotification = new Notification(SMS, "Your password has been changed");
        Notification pushNotification = new Notification(PUSH, "You have a new message!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
