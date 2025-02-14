package school.faang.sprint2.task_57659;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        try {
            notificationManager.registerHandler(NotificationType.EMAIL,
                    notification -> System.out.println("Email: " + notification.getMessage())
            );

            notificationManager.registerHandler(NotificationType.SMS,
                    notification -> System.out.println("SMS: " + notification.getMessage())
            );

            notificationManager.registerHandler(NotificationType.PUSH,
                    notification -> System.out.println("Push Notification: " + notification.getMessage())
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Mistake: " + e.getMessage());
        }

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account is activated");
        Notification smsNotification = new Notification(NotificationType.SMS, "Your password has been changed");
        Notification pushNotification = new Notification(NotificationType.PUSH, "You have a new message!");

        try {
            notificationManager.sendNotification(emailNotification);
            notificationManager.sendNotification(smsNotification);
            notificationManager.sendNotification(pushNotification);
        } catch (IllegalArgumentException e) {
            System.out.println("Mistake" + e.getMessage());
        }
    }
}
