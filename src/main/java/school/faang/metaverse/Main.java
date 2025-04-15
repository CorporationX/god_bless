package school.faang.metaverse;

/*
* Related to JIRA ticket: BJS2-71883
 * */
public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.printf("📧 Email: %s\n", notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.printf("📱 SMS: %s\n", notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.printf("🔔 Push Notification: %s\n", notification.getMessage()));

        notificationManager.addFilter(notification -> !notification.getMessage().contains("badword"));

        notificationManager.setCorrector(notification ->
                new Notification(notification.getType(),
                        notification.getMessage() + " [Sent by Meta]"));

        System.out.println("\n=== Sending Notifications (should be modified by corrector) ===");
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account is activated!");
        Notification smsNotification = new Notification(NotificationType.SMS, "Your password has been changed!");
        Notification pushNotification = new Notification(NotificationType.PUSH, "You have a new message!");
        Notification blockedNotification = new Notification(NotificationType.EMAIL, "This message contains badword!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        System.out.println("\n=== Attempting to send a notification with prohibited content ===");
        try {
            notificationManager.sendNotification(blockedNotification);
        } catch (IllegalStateException e) {
            System.out.printf("🚫 Blocked notification: %s\n", e.getMessage());
        }
    }
}
