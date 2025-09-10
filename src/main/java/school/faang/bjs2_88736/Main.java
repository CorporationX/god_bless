package school.faang.bjs2_88736;

import static school.faang.bjs2_88736.NotificationType.EMAIL;
import static school.faang.bjs2_88736.NotificationType.PUSH;
import static school.faang.bjs2_88736.NotificationType.SMS;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.registerHandler(EMAIL, notification -> System.out.println("Email: " + notification.getMessage()));
        manager.registerHandler(PUSH, notification -> System.out.println("PUSH " + notification.getMessage()));

        Notification notificationPush = new Notification(PUSH, "Balance is replenished");
        Notification notificationSms = new Notification(SMS, "Balance is replenished");
        Notification notificationEmail = new Notification(EMAIL, "I'll find you!! Fuck!!");
        manager.sendNotification(notificationPush);
        manager.sendNotification(notificationSms);
        manager.sendNotification(notificationEmail);
    }
}
