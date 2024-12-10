package school.faang.task_46642;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Sending via email: " + notification.message()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("Sending SMS: " + notification.message()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Sending push notification: " + notification.message()));

        notificationManager.addFilter("restricted", notification -> {
            if (notification.message().contains("restricted")) {
                System.out.println("Restricted content detected in the message: " + notification.message());
            }
        });

        Notification emailNotification = new Notification(NotificationType.EMAIL.getType(),
                "Your account has been successfully activated.");
        Notification smsNotification = new Notification(NotificationType.SMS.getType(),
                "You successfully changed your password.");
        Notification pushNotification = new Notification(NotificationType.PUSH.getType(),
                "New post from user: JohnDoe.");
        Notification filteredNotification = new Notification(NotificationType.EMAIL.getType(),
                "Contains restricted content in the text.");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.processFilters(filteredNotification);
    }
}