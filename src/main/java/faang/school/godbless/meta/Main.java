package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        final String EMAIL = "email";
        final String SMS = "sms";
        final String PUSH = "push";

        notificationManager.registerHandler(EMAIL, (notification) -> System.out.println("Email send mail: " + notification.getMessage()));
        notificationManager.registerHandler(SMS, (notification) -> System.out.println("Send SMS: " + notification.getMessage()));
        notificationManager.registerHandler(PUSH, (notification) -> System.out.println("Send push-notification: " + notification.getMessage()));

        Notification emailNotification = new Notification(EMAIL, "Account activated ");
        Notification smsNotification = new Notification(PUSH, "Password changed ");
        Notification pushNotification = new Notification(PUSH, "New post published ");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }

}