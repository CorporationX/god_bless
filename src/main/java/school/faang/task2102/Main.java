package school.faang.task2102;

public class Main {
    private static final String EMAIL_NOTIFICATION = "email";
    private static final String SMS_NOTIFICATION = "sms";
    private static final String PUSH_NOTIFICATION = "push";
    private static final String FAX_NOTIFICATION = "fax";

    public static void main(String[] args) {
        NotificationManager notificationManager = createAndRegisterNotificationManager();

        sendNotifications(notificationManager);
    }

    private static NotificationManager createAndRegisterNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(EMAIL_NOTIFICATION,
                notification -> System.out.println("Sending email notification: " + notification.getMessage()));

        notificationManager.registerHandler(SMS_NOTIFICATION,
                notification -> System.out.println("Sending SMS notification: " + notification.getMessage()));

        notificationManager.registerHandler(PUSH_NOTIFICATION,
                notification -> System.out.println("Sending push notification: " + notification.getMessage()));

        return notificationManager;
    }

    private static void sendNotifications(NotificationManager notificationManager) {
        notificationManager.sendNotification(new Notification(EMAIL_NOTIFICATION, "You've got a new email."));
        notificationManager.sendNotification(new Notification(SMS_NOTIFICATION, "Your package has been delivered."));
        notificationManager.sendNotification(new Notification(PUSH_NOTIFICATION, "New update available."));
        notificationManager.sendNotification(new Notification(FAX_NOTIFICATION, "New fax"));
    }
}