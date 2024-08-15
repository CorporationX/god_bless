package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Send by EMAIL: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification -> System.out.println("Send by SMS: " + notification.getMessage())));
        notificationManager.registerHandler("push", (notification -> System.out.println("POP-UP: " + notification.getMessage())));

        Notification emailNotification = new Notification("email", "New message from three body");
        Notification smsNotification = new Notification("sms", "Next payment will be tomorrow");
        Notification pushNotification = new Notification("push", "Somebody liked your photo");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
