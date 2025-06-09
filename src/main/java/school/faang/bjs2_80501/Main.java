package school.faang.bjs2_80501;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalTime;

import static school.faang.bjs2_80501.NotificationFilterFactory.DEFAULT_MIN_LENGTH;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        NotificationFilterFactory notificationFilterFactory = new NotificationFilterFactory();

        Notification notificationSms = new Notification(NotificationType.SMS,
                "This message send way SMS");
        Notification notificationPush = new Notification(NotificationType.PUSH,
                "This message is sent via PUSH");
        Notification notificationEmail = new Notification(NotificationType.EMAIL,
                "This message is sent via EMAIL");

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println(notification.getMessage()));

        notificationManager.sendNotification(notificationSms,
                notificationFilterFactory.filterForbiddenWords());

        notificationManager.sendNotification(notificationEmail,
                notificationFilterFactory.filterMessageLength(DEFAULT_MIN_LENGTH));

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> log.info(notification.getMessage() + ". Time: " + LocalTime.now()));

        notificationManager.sendNotification(notificationPush,
                notificationFilterFactory.filterForbiddenWords());

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> log.info(notification.getMessage() + ". Date: " + LocalDate.now()));

        notificationManager.sendNotification(notificationEmail,
               notificationFilterFactory.filterMessageLength(DEFAULT_MIN_LENGTH));
    }
}
