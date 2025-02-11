package school.faang.BJS2_57678;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        notificationManager.setCorrector(notification ->
                new Notification(notification.getType(), notification.getMessage() + " from company Google")
        );

        notificationManager.addFilter(notification -> notification.getMessage().toLowerCase().contains("мир"));
        notificationManager.addFilter(notification -> notification.getMessage().toLowerCase().contains("война"));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Мир во всем мире");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Война это плохо!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }

}
