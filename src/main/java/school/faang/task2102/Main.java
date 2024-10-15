package school.faang.task2102;

public class Main {
    private static final String EMAIL_NOTIFICATION = "email";
    private static final String SMS_NOTIFICATION = "sms";
    private static final String PUSH_NOTIFICATION = "push";
    private static final String FAX_NOTIFICATION = "fax";

    public static void main(String[] args) {
        NotificationManager notificationManager = initializeNotificationManager();
        sendNotifications(notificationManager);
    }

    private static NotificationManager initializeNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();
        registerHandlers(notificationManager);
        registerFilters(notificationManager);
        return notificationManager;
    }

    private static void registerHandlers(NotificationManager notificationManager) {
        //TODO норм не ставить () в lambda, если параметр только один?
        notificationManager.registerHandler(EMAIL_NOTIFICATION,
                (notification) -> System.out.println("Sending email notification: " + notification.getMessage()));
        notificationManager.registerHandler(SMS_NOTIFICATION,
                notification -> System.out.println("Sending SMS notification: " + notification.getMessage()));
        notificationManager.registerHandler(PUSH_NOTIFICATION,
                notification -> System.out.println("Sending push notification: " + notification.getMessage()));
    }

    private static void registerFilters(NotificationManager notificationManager) {
        notificationManager.registerFilter(EMAIL_NOTIFICATION, Filter::filterMessageContent);
        notificationManager.registerFilter(SMS_NOTIFICATION, Filter::filterMessageContent);
        notificationManager.registerFilter(PUSH_NOTIFICATION, Filter::filterMessageContent);
    }

    private static void sendNotifications(NotificationManager notificationManager) {
        notificationManager.sendNotification(new Notification(EMAIL_NOTIFICATION, "Hello, your password: mysecret123."));
        notificationManager.sendNotification(new Notification(SMS_NOTIFICATION, "This is a bad word: niger."));
        notificationManager.sendNotification(new Notification(PUSH_NOTIFICATION, "User used inappropriate word: shit."));
        notificationManager.sendNotification(new Notification(FAX_NOTIFICATION, "New fax"));
    }
}