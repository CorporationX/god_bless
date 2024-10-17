package school.faang.task2102;

import java.util.List;

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
        notificationManager.registerHandler(EMAIL_NOTIFICATION,
                notification -> System.out.println("Sending email notification: " + notification.message()));
        notificationManager.registerHandler(SMS_NOTIFICATION,
                notification -> System.out.println("Sending SMS notification: " + notification.message()));
        notificationManager.registerHandler(PUSH_NOTIFICATION,
                notification -> System.out.println("Sending push notification: " + notification.message()));
    }

    private static void registerFilters(NotificationManager notificationManager) {
        notificationManager.registerFilters(EMAIL_NOTIFICATION, List.of(FilterType.SENSITIVE));
        notificationManager.registerFilters(SMS_NOTIFICATION, List.of(FilterType.FORBIDDEN, FilterType.SENSITIVE));
        notificationManager.registerFilters(PUSH_NOTIFICATION, List.of(FilterType.FORBIDDEN));
    }

    private static void sendNotifications(NotificationManager notificationManager) {
        notificationManager.sendNotification(new Notification(EMAIL_NOTIFICATION, "Hello, your password: mysecret123."));
        notificationManager.sendNotification(new Notification(SMS_NOTIFICATION, "This is a bad word: niger. Password: mysecret123."));
        notificationManager.sendNotification(new Notification(PUSH_NOTIFICATION, "User used inappropriate word: shit."));
        notificationManager.sendNotification(new Notification(FAX_NOTIFICATION, "New fax"));
    }
}