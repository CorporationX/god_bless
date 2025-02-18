package school.faang.task_BJS2_57974;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        //регистрация обработчиков
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMESSAGE()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMESSAGE()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMESSAGE()));

        //Отправка уведомлений
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account has been blocked.");
        Notification smsNotification = new Notification(NotificationType.SMS, "You've been approved credit.");
        Notification pushNotification = new Notification(NotificationType.PUSH, "You've been recieved a gold status.");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
