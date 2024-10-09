package school.faang.BJS2_34731_MetaUniverse;

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

        Notification emailNotification = new Notification("email", "Your order has been shipped and is on its way!");
        Notification smsNotification = new Notification("sms", "Reminder: Your appointment is scheduled for tomorrow at 10 AM.");
        Notification pushNotification = new Notification("push", "Congratulations! You have reached a new level in the game.");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
