package BJS2_22025;

public class Main {
    public static void main(String[] args) {
        NotificationManager.registerHandler("email", notification ->
                System.out.println("Sending email: " + notification.getMessage()));
        NotificationManager.registerHandler("sms", notification ->
                System.out.println("Sending sms: " + notification.getMessage()));
        NotificationManager.registerHandler("push", notification ->
                System.out.println("Sending push-notification: " + notification.getMessage()));

        Notification emailNotification = new Notification("email",
                "Your account successfully activated!");
        Notification smsNotification = new Notification("sms",
                "You successfully changed your password!");
        Notification pushNotification = new Notification("push",
                "New post from Bob Marley!");

        NotificationManager.sendNotification(emailNotification);
        NotificationManager.sendNotification(smsNotification);
        NotificationManager.sendNotification(pushNotification);
    }
}
