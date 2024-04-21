package faang.school.godbless.metauniverse;
import lombok.Getter;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler("email", notification ->
                System.out.println("Sending email notification: " + notification.getMessage()));
        manager.registerHandler("sms", notification ->
                System.out.println("Sending SMS notification: " + notification.getMessage()));
        manager.registerHandler("push", notification ->
                System.out.println("Sending push notification: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Your account has been successfully activated");
        Notification smsNotification = new Notification("sms", "You have successfully changed your password");
        Notification pushNotification = new Notification("push", "New post from user: Elon_Musk");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
    }
}


