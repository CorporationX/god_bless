package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        NotificationManagerWithFilters notificationManagerWithFilters = new NotificationManagerWithFilters();

        notificationManager.registerHandler("email", notification -> System.out.println("Sending email: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println("Sending sms: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification -> System.out.println("Sending push notification: " + notification.getMessage()));

        notificationManagerWithFilters.registerFilter("email", notification -> !notification.getMessage().contains("spam"));


        Notification emailNotification = new Notification("email", "Your account has been successfully activated");
        Notification smsNotification = new Notification("sms", "Your password has been successfully changed");
        Notification pushNotification = new Notification("push", "New post by JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
