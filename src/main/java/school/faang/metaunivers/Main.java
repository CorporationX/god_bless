package school.faang.metaunivers;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Registering notification handlers
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Sending email: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Sending SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Sending push notification: " + notification.getMessage())
        );


    }
}

