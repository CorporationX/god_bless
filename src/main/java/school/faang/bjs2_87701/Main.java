package school.faang.bjs2_87701;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
            notification -> System.out.println("Email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push: " + notification.getMessage()));

        Notification emailNotification =
                new Notification(NotificationType.EMAIL, "Подтвердите свой email для активации");
        Notification smsNotification =
                new Notification(NotificationType.SMS, "Ваш код авторизации 002423, никому не говорите его");
        Notification pushNotification =
                new Notification(NotificationType.PUSH, "Новая заявка в друзья от мат");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
