package bjs2_33401;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("Telegram", (notification) ->
                System.out.println("You received a new message: " + notification.getMessage()));
        notificationManager.registerHandler("email", (notification) ->
                System.out.println("You received a new email: " + notification.getMessage()));

        notificationManager.registerFilter("Telegram", (message) -> {
            for (String word : NotificationManager.getUnaccaptableWords()) {
                message = message.replaceAll("(?i)" + word, "***");
            }
            return message;
        });
        notificationManager.registerFilter("email", (message) -> {
            for (String word : NotificationManager.getUnaccaptableWords()) {
                message = message.replaceAll("(?i)" + word, "*****");
            }
            return message;
        });

        Notification telegramNotification = new Notification("Telegram", "Message from Java magics");
        Notification emailNotification = new Notification("email", "You have been recruited by Spotify");
        Notification badNotificationTelegram = new Notification("Telegram", "My friend loves to drink alcohol. " +
                "He once got his driver license suspended for driving while being drunk. He regrets it till now");
        Notification badNotificationEmail = new Notification("email", "My friend loves to drink alcohol. " +
                "He once got his driver license suspended for driving while being drunk. He regrets it till now");

        notificationManager.sendNotification(telegramNotification);
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(badNotificationTelegram);
        notificationManager.sendNotification(badNotificationEmail);
    }
}
