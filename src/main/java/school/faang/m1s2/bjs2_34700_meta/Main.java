package school.faang.m1s2.bjs2_34700_meta;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.getBanWords().addAll(List.of("trump", "twitter"));

        Notification emailNotification = new Notification("email", "You're now registered in system");
        Notification smsNotification = new Notification("sms", "Transaction successful");
        Notification pushNotification = new Notification("push", "Please enter the following passcode");

        notificationManager.registerHandler("email", (notification ->
                System.out.println(notification.getMessage())));

        notificationManager.registerHandler("sms", (notification ->
                System.out.println(notification.getMessage())));

        notificationManager.registerHandler("push", (notification ->
                System.out.println(notification.getMessage())));

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.sendNotification(new Notification("sms", "Trump for president!"));
        notificationManager.sendNotification(new Notification("email", "Join Twitter, we're better"));

        notificationManager.sendNotification(new Notification("telepathy", "Your mind is clear"));
    }
}
