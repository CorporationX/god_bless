package school.faang.meta_universee;

import school.faang.meta_universee.handler.EmailNotificationHandler;
import school.faang.meta_universee.handler.PushNotificationHandler;
import school.faang.meta_universee.handler.SmsNotificationHandler;

import static school.faang.meta_universee.Notification.NotificationType.EMAIL;
import static school.faang.meta_universee.Notification.NotificationType.PUSH;
import static school.faang.meta_universee.Notification.NotificationType.SMS;

public class Main {
    public static void main(String[] args) {
        String notificationEmailMessage = "Hello person who has chosen EMAIL type of " +
                "notifications! Thanks for choosing us!";
        String notificationSmsMessage = "Hello person who has chosen SMS type of " +
                "notifications! Thanks for choosing us!";
        String notificationPushMessage = "Hello person who has chosen PUSH type of " +
                "notifications! Thanks for choosing us!";

        Notification notificationEmail = new Notification(EMAIL, notificationEmailMessage);
        Notification notificationSms = new Notification(SMS, notificationSmsMessage);
        Notification notificationPush = new Notification(EMAIL, notificationPushMessage);

        NotificationManager notificationManagerMarina = new NotificationManager();

        notificationManagerMarina.registerHandler(EMAIL, new EmailNotificationHandler());
        notificationManagerMarina.registerHandler(SMS, new SmsNotificationHandler());
        notificationManagerMarina.registerHandler(PUSH, new PushNotificationHandler());

        notificationManagerMarina.sendNotification(notificationEmail);

        Notification notificationCensored = new Notification(SMS, "That's fucking crazy");
        notificationManagerMarina.filterNotification(notificationCensored);
        notificationCensored = notificationManagerMarina.correctNotification(notificationCensored);
        System.out.println(notificationCensored.getMessage());

        Notification notificationClear = new Notification(PUSH, "Crazy!");
        notificationManagerMarina.filterNotification(notificationClear);
        notificationClear = notificationManagerMarina.correctNotification(notificationClear);
        System.out.println(notificationClear.getMessage());
    }
}
