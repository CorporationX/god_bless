package faang.school.godbless.func.meta;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Sending an email: " + notification.message()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Sending push notification: " + notification.message()));

        Notification emailNotification = new Notification("email", "You might know these people...");
        Notification pushNotification = new Notification("push", "You have a new subscriber!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
