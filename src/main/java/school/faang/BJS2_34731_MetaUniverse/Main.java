package school.faang.BJS2_34731_MetaUniverse;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Sending email notification...\n" + notification.getMessage())
        );
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Sending sms notification...\n" + notification.getMessage())
        );
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Sending push notification...\n" + notification.getMessage())
        );

        notificationManager.registerFilter("Alcohol filter", notification -> {
            Set<String> alcoholNames = Set.of("beer", "rum", "vodka");
            if (alcoholNames.stream().anyMatch(alcoholName -> notification.getMessage().toLowerCase().contains(alcoholName))) {
                System.out.println("Notification message text contains alcohol name!");
                return true;
            }
            return false;
        });

        notificationManager.registerFilter("Spam filter", notification -> {
            if (notification.getMessage().toLowerCase().contains("spam")) {
                System.out.println("Spam has been detected in notification message text!");
                return true;
            }
            return false;
        });

        Notification emailNotification = new Notification("email", "Check out our new vodka!");
        Notification unknownTypeNotification = new Notification("unknown", "Hello! My name is Giovanni Giorgio");
        Notification smsNotification = new Notification("sms", "This is a spam message!");
        Notification pushNotification = new Notification("push", "Congratulations! You have reached a new level in the game.");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(unknownTypeNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
