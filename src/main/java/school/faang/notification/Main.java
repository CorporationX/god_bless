package school.faang.notification;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        setupNotificationHandlers(notificationManager);
        dispatchNotifications(notificationManager);
        setupFilters(notificationManager);
        checkNotificationFilters(notificationManager);
    }

    private static void checkNotificationFilters(NotificationManager notificationManager) {
        Notification smsNotification = new Notification("sms", "You have successfully changed your password.");
        Notification pushNotification = new Notification("push", "New post from user: badword1");

        System.out.println("Notification 1 is inappropriate: " + notificationManager.isInappropriate(smsNotification));
        System.out.println("Notification 2 is inappropriate: " + notificationManager.isInappropriate(pushNotification));

    }

    private static void setupFilters(NotificationManager notificationManager) {
        notificationManager.registerFilter("profanity", notification -> notification.getMessage().matches(".*\\b(badword1|badword2)\\b.*"));
        notificationManager.registerFilter("spam", notification -> notification.getMessage().contains("Buy now") || notification.getMessage().contains("Click here"));
        notificationManager.registerFilter("hate speech", notification -> notification.getMessage().matches(".*\\b(hateword1|hateword2)\\b.*"));
    }

    private static void dispatchNotifications(NotificationManager notificationManager) {
        Notification emailNotification = new Notification("email", "Your account has been successfully activated.");
        Notification smsNotification = new Notification("sms", "You have successfully changed your password.");
        Notification pushNotification = new Notification("push", "New post from user: badword1");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }


    private static void setupNotificationHandlers(NotificationManager notificationManager) {
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Send by email: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Send SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Send a push notification: " + notification.getMessage())
        );
    }
}


