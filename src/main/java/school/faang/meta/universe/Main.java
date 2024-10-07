package school.faang.meta.universe;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Email: " + notification.message()));
        notificationManager.registerHandler("sms", (notification -> System.out.println("SMS: " + notification.message())));

        Notification notification1 = new Notification("email", "the email was sent successfully");
        Notification notification2 = new Notification("sms", "you have new message");

        notificationManager.sendNotification(notification1);
        notificationManager.sendNotification(notification2);
    }
}
