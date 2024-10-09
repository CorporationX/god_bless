package school.faang.Lambda.BJS2_34711;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("Email",
                (notification) -> System.out.println("email message " + notification.getMessage()));

        notificationManager.registerHandler("Sms",
                (notification) -> System.out.println("sms message " + notification.getMessage()));

        notificationManager.registerHandler("Telegram",
                (notification) -> System.out.println("telegram message " + notification.getMessage()));

        notificationManager.sendNotification(new Notification("Email", "message in email"));
        notificationManager.sendNotification(new Notification("Sms", "message in sms"));
        notificationManager.sendNotification(new Notification("Telegram", "message in Telegram"));
    }
}
