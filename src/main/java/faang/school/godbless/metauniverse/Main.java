package faang.school.godbless.metauniverse;

public class Main {

    public static void main(String[] args) {
        var notificationManager = getNotificationManager();

        var emailNotification = new Notification("email", "account is activated");
        var smsNotification = new Notification("sms", "code is XXXX");
        var pushNotification = new Notification("push", "new message received");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }

    private static NotificationManager getNotificationManager() {
        var notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                notification -> System.out.println("email sending: " + notification.getMessage()));
        notificationManager.registerHandler("sms",
                notification -> System.out.println("sms sending: " + notification.getMessage()));
        notificationManager.registerHandler("push",
                notification -> System.out.println("push-notification sending: " + notification.getMessage()));

        return notificationManager;
    }

}
