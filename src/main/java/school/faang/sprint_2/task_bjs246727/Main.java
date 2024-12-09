package school.faang.sprint_2.task_bjs246727;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        registerHandlers(notificationManager);

        Notification emailNotification = new Notification(NotificationType.EMAIL, "account activated");
        Notification smsNotification = new Notification(NotificationType.SMS, "password chaged");
        Notification pushNotification = new Notification(NotificationType.PUSH, "new post");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }

    private static void registerHandlers(NotificationManager notificationManager) {
        notificationManager.registerHandler(
                NotificationType.EMAIL,
                notification -> System.out.println("Sending email: " + notification.message())
        );
        notificationManager.registerHandler(
                NotificationType.SMS,
                notification -> System.out.println("Sending SMS: " + notification.message())
        );
        notificationManager.registerHandler(
                NotificationType.PUSH,
                notification -> System.out.println("Sending push: " + notification.message())
        );
    }
}
