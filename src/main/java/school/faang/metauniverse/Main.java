package school.faang.metauniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Send message by email: " + notification.message())
        );
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Send SMS: " + notification.message())
        );
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Send push-notification: " + notification.message())
        );

        Notification emailNotification = new Notification("email", "Email message");
        Notification smsNotification = new Notification("sms", "This is a Spam message. SPAM is not allowed. Avoid spam!");
        Notification pushNotification = new Notification("push", "PUSH notification - SUBSCRIBE");

        System.out.println("\nSENDING NOTIFICATION MESSAGES");
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.registerSpamFilter("email", (message) -> message.toLowerCase().contains("offer"));
        notificationManager.registerSpamFilter("sms", (message) -> message.toLowerCase().contains("spam"));
        notificationManager.registerSpamFilter("push", (message) -> message.toLowerCase().contains("subscribe"));

        System.out.println("\nFILTERING MESSAGES");
        notificationManager.filterNotification(emailNotification);
        notificationManager.filterNotification(smsNotification);
        notificationManager.filterNotification(pushNotification);

        System.out.println("\nPROCESSING MESSAGES");
        notificationManager.registerMessageProcessor("email", String::toUpperCase);
        notificationManager.registerMessageProcessor("sms", (message) -> message.replaceAll("(?i)spam", "***"));
        notificationManager.registerMessageProcessor("push", (message) -> {
            message = message.replaceAll("(?i)subscribe", "***");
            if (message.contains("***")) {
                message = "Message was automatically updated: ".concat(message);
            }
            return message;
        });

        notificationManager.processMessage(emailNotification);
        notificationManager.processMessage(smsNotification);
        notificationManager.processMessage(pushNotification);
    }
}
