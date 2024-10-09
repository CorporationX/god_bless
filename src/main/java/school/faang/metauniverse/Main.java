package school.faang.metauniverse;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Send sms: " + notification.getMessage())
        );
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Send email: " + notification.getMessage())
        );

        Notification smsNotification = new Notification("sms", "+123456789 tried to call you");
        Notification emailNotification = new Notification("email", "Hello, Alex! ...");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);
    }
}
