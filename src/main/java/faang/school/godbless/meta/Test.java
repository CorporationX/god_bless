package faang.school.godbless.meta;

public class Test {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        String pushHandlerId = notificationManager.registerHandler("push", (notification) -> System.out.println("Sending push notification: " + notification.getMessage()));

        Notification pushNotification = new Notification("push", "New post from user: JohnDoe");

        notificationManager.sendNotification(pushNotification);

        notificationManager.unregisterHandlerById(pushHandlerId);
        notificationManager.sendNotification(pushNotification);

        notificationManager.registerHandler("sms", (notification) -> System.out.println("Sending SMS: " + notification.getMessage()));
        String smsFilterId = notificationManager.registerFilter(
                "sms",
                notification -> notification.getMessage().toLowerCase().contains("suspicious activity"),
                notification -> System.out.println("DANGER! " + notification.getMessage()),
                notification -> "DANGER! " + notification.getMessage()
        );

        Notification smsNotification = new Notification("sms", "You have successfully changed your password");
        Notification spamSmsNotification = new Notification("sms", "Suspicious activity detected on your account.");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(spamSmsNotification);

        notificationManager.unregisterFilterById(smsFilterId);

        notificationManager.sendNotification(spamSmsNotification);
    }
}
