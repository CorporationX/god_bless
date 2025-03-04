package school.faang.meta_universee;

import static school.faang.meta_universee.Notification.NotificationType.EMAIL;
import static school.faang.meta_universee.Notification.NotificationType.PUSH;
import static school.faang.meta_universee.Notification.NotificationType.SMS;

public class Main {
    public static void main(String[] args) {
        Notification notification1 = new Notification(EMAIL, "Hello person who has chosen email");
        NotificationManager notificationManagerMarina = new NotificationManager();
        notificationManagerMarina.registerHandler(EMAIL, notification
                -> System.out.println("Notification for email! Content: " + notification.getMessage()));
        notificationManagerMarina.registerHandler(SMS, notification
                -> System.out.println("Notification for email! Content: " + notification.getMessage()));
        notificationManagerMarina.registerHandler(PUSH, notification
                -> System.out.println("Notification for email! Content: " + notification.getMessage()));

        notificationManagerMarina.sendNotification(notification1);
    }
}
