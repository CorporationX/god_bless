package school.faang.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL, notification -> System.out.println("here we send email to user with a message: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS, notification -> System.out.println("here we send sms to user with a message: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH, notification -> System.out.println("here we send PUSH notification to user with a message: " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your notification #1 sent by email");
        Notification smsNotification = new Notification(NotificationType.SMS, "Your notification #2 sent by sms");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Your notification #3 sent by PUSH");
        Notification notValidEmailNotification = new Notification(NotificationType.EMAIL, "Your notification sent by email");
        Notification emptyEmailNotification = new Notification(NotificationType.EMAIL, "");

        notificationManager.registerFilter(NotificationType.EMAIL, notification -> notification.getMessage().contains("#"));
        notificationManager.registerFilter(NotificationType.EMAIL, notification -> !notification.getMessage().isBlank());

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(notValidEmailNotification);
        notificationManager.sendNotification(emptyEmailNotification);

        System.out.println("Errors list : " + notificationManager.getErrors());
    }
}
