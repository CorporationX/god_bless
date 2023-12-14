package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerSendHandler("email", (notification) ->
                System.out.println("Sending by email: " + notification.getMessage()));
        notificationManager.registerSendHandler("sms", (notification) ->
                System.out.println("Sending SMS: " + notification.getMessage()));
        notificationManager.registerSendHandler("push", (notification) ->
                System.out.println("Sending a push notification: " + notification.getMessage()));
        notificationManager.registerContentFilterHandler("f@ck", (notification, badWord) -> {
            notification.setMessage(notification.getMessage().replace(badWord, "<profanity!>"));
            return notification;
        });
        notificationManager.registerContentFilterHandler("bomb", (notification, badWord) -> {
            notification.setMessage(notification.getMessage().replace(badWord, "<censure!>"));
            return notification;
        });

        Notification badNotification = new Notification("email", "What the f@ck bomb?");
        Notification emailNotification = new Notification("email", "Your account has been activated");
        Notification smsNotification = new Notification("sms", "You changed your password");
        Notification pushNotification = new Notification("push", "New post from user: rater");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.check(badNotification);
        notificationManager.sendNotification(badNotification);
    }
}
