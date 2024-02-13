package faang.school.godbless.metaverse;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        Notification emailNotification = new Notification("email", "Successful registration");
        Notification smsNotification = new Notification("sms", "Password changed");
        Notification pushNotification = new Notification("push", "New message");

        notificationManager.registerHandler("email", notification -> System.out.println("Email send: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println("Sms send: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification -> System.out.println("Push send: " + notification.getMessage()));

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
