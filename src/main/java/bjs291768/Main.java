package bjs291768;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(NotificationType.EMAIL, notification -> System.out.println("email: "
                + notification.message()));
        manager.registerHandler(NotificationType.SMS, notification -> System.out.println("sms: "
                + notification.message()));
        manager.registerHandler(NotificationType.PUSH, notification -> System.out.println("push: "
                + notification.message()));

        manager.registerFilter(notification -> !notification.message().contains("badword"));
        manager.registerFilter(notification -> !notification.message().isBlank());

        manager.registerEditor(notification -> new Notification(notification.type(),
                notification.message() + " With best regards, team."));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Welcome to your account!");
        Notification smsNotification = new Notification(NotificationType.SMS, "Your code is 1111");
        Notification pushNotification = new Notification(NotificationType.PUSH, "New feature is available!");
        Notification smsNotification2 = new Notification(NotificationType.SMS, "");
        Notification pushNotification2 = new Notification(NotificationType.PUSH, "badword this is blabla");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
        manager.sendNotification(smsNotification2);
        manager.sendNotification(pushNotification2);
    }
}
