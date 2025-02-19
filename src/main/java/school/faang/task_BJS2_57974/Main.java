package school.faang.task_BJS2_57974;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        //Добавление фильра
        notificationManager.addFilter(notification -> !notification.getMessage().contains("swear word"));

        //регистрация обработчиков
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage()));

        //Отправка уведомлений
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account has been blocked.");
        Notification smsNotification = new Notification(NotificationType.SMS, "You've been approved credit.");
        Notification pushNotification = new Notification(NotificationType.PUSH, "You've been received a gold status.");
        Notification pushNotificationWithSwearWord = new Notification(NotificationType.PUSH, "swear word");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(pushNotificationWithSwearWord);
    }
}
