package school.faang.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Send by email: " + notification.getMessage()));

        notificationManager.registerHandler("SMS",
                (notification) -> System.out.println("You have received an SMS message: " + notification.getMessage()));

        notificationManager.registerHandler("push-notification",
                (notification) -> System.out.println("You have received a push notification: " + notification.getMessage()));

        notificationManager.registerHandler("spam",
                (notification) -> System.out.println("You have received a SPAM: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "You joined the Taliban");
        Notification smsNotification = new Notification("SMS", "Credit for 5,000,000 from T-Bank!");
        Notification pushNotification = new Notification("push-notification", "Spin the slots and " +
                "win the jackpot");
        Notification spamNotification = new Notification("spam", "Get 100 free spins and hit the jackpot");


        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(spamNotification);
    }
}