package school.faang.bjs2_80501;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static school.faang.bjs2_80501.ForbiddenWord.FORBIDDEN_WORDS;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Notification notificationSms = new Notification(NotificationType.SMS,
                "This message send way SMS");
        Notification notificationPush = new Notification(NotificationType.PUSH,
                "This message is sent via PUSH");
        Notification notificationEmail = new Notification(NotificationType.EMAIL,
                "This message is sent via EMAIL");

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println(notification.getMessage()));

        notificationManager.sendNotification(notificationSms,
                message -> {
                    String[] messageSplit = message.split("[;,.\\s-]");
                    return Arrays.stream(messageSplit).noneMatch(FORBIDDEN_WORDS::contains);
                });

        notificationManager.sendNotification(notificationEmail,
                message -> {
                    String[] messageSplit = message.split("[;,.\\s-]");
                    return messageSplit.length > 5;
                });

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println(notification.getMessage() + ". Time: " + LocalTime.now()));

        notificationManager.sendNotification(notificationPush,
                message -> {
                    String[] messageSplit = message.split("[;,.:\\s-]");
                    return Arrays.stream(messageSplit).anyMatch(word -> word.equalsIgnoreCase("push"));
                });

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println(notification.getMessage() + ". Date: " + LocalDate.now()));

        notificationManager.sendNotification(notificationEmail,
                message -> {
                    String[] messageSplit = message.split("[;,.\\s-]");
                    return messageSplit.length > 5;
                });
    }
}
