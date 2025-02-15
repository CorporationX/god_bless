package school.faang;

public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(Notification.NotificationType.EMAIL, notification ->
                System.out.println("send email " + notification.getMessage()));

        notificationManager.registerHandler(Notification.NotificationType.SMS, notification ->
                System.out.println("send SMS " + notification.getMessage()));

        notificationManager.registerHandler(Notification.NotificationType.PUSH, notification ->
                System.out.println("send PUSH " + notification.getMessage()));

        Notification emailNotification = new Notification(Notification.NotificationType.EMAIL,
                "HEllo");
        Notification smsNotification = new Notification(Notification.NotificationType.SMS,
                "How are you");
        Notification pushNotification = new Notification(Notification.NotificationType.PUSH,
                "IM Fine");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);


    }
}
