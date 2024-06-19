package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("Email", notification -> {
            System.out.println("Email" + notification.message());
        });
        notificationManager.registerHandler("Sms", notification -> {
            System.out.println("Sms" + notification.message());
        });

        Notification emailNotification = new Notification("Email", "This this a notification via Email");
        Notification smsNotification = new Notification("Sms", "This is a sms notification");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(new Notification("Error", "No such notification type"));
    }
}
