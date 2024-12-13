package school.faang.task_46766;

import static school.faang.task_46766.NotificationType.EMAIL;
import static school.faang.task_46766.NotificationType.PUSH;
import static school.faang.task_46766.NotificationType.SMS;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        Notification smsnotification = new Notification(SMS, "you successfully changed your password");
        Notification emailnotification = new Notification(EMAIL, "you successfully signed in");
        Notification pushnotification = new Notification(PUSH, "new notification from your friend");

        notificationManager.registerHandler(SMS,
                notification -> System.out.println("Sending sms: " + notification.getMessage()));
        notificationManager.registerHandler(EMAIL,
                notification -> System.out.println("Sending email: " + notification.getMessage()));
        notificationManager.registerHandler(PUSH,
                notification -> System.out.println("Sending push: " + notification.getMessage()));

        notificationManager.sendNotification(smsnotification);
        notificationManager.sendNotification(emailnotification);
        notificationManager.sendNotification(pushnotification);
    }
}