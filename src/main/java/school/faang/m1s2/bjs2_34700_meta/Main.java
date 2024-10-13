package school.faang.m1s2.bjs2_34700_meta;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.addFilter("politics", Set.of("trump", "biden"));
        notificationManager.addFilter("business", Set.of("twitter", "meta"));

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

        notificationManager.sendNotification(new Notification("sms", "Trump for president!"), "politics");
        notificationManager.sendNotification(new Notification("email", "Join Twitter, we're better"), "business");

        notificationManager.sendNotification(new Notification("telepathy", "Your mind is clear"));
    }
}
