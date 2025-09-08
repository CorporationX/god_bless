package school.faang.bjs2_87573;

import school.faang.bjs2_87573.notification.Notification;
import school.faang.bjs2_87573.notification.NotificationManager;

import static school.faang.bjs2_87573.notification.Notification.NotificationType.EMAIL;
import static school.faang.bjs2_87573.notification.Notification.NotificationType.SMS;
import static school.faang.bjs2_87573.notification.Notification.NotificationType.PUSH;

public class Main {
    public static void main(String[] args) {
        Notification firstNotification = new Notification("Olympic Party invitation from Zeus", EMAIL);
        Notification secondNotification = new Notification("Hello, how are you?", SMS);
        Notification thirdNotification = new Notification("Crazy discounts at Walmart!", PUSH);

        NotificationManager.registerHandler(EMAIL,
                notification -> System.out.println(EMAIL + ": " + notification.message()));

        NotificationManager.registerHandler(SMS,
                notification -> System.out.println(SMS + ": " + notification.message()));

        NotificationManager.registerHandler(PUSH,
                notification -> System.out.println(PUSH + ": " + notification.message()));

        NotificationManager.sendNotification(firstNotification);
        NotificationManager.sendNotification(secondNotification);
        NotificationManager.sendNotification(thirdNotification);
        System.out.println();

        NotificationManager.updateNotificationHandler(EMAIL,
                notification -> System.out.println("You have a new message:\n" + notification.message()));

        NotificationManager.sendNotification(firstNotification);
    }
}
