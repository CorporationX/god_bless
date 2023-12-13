package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) ->
                System.out.println("Sending by email: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) ->
                System.out.println("Sending SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) ->
                System.out.println("Sending a push notification: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Your account has been activated");
        Notification smsNotification = new Notification("sms", "You changed your password");
        Notification pushNotification = new Notification("push", "New post from user:: rater");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
