package school.faang;


public class Main {

    public static void main(String[] args) {

        //оповещения
        Notification emailNotification = new Notification(
                NotificationType.EMAIL, " Notification for Email ");
        Notification smsNotification = new Notification(
                NotificationType.SMS, " Notification for SMS ");
        Notification pushNotification = new Notification(
                NotificationType.PUSH, " Notification for Push "
        );

        //регистрация обработчиков
        NotificationManager manager = new NotificationManager();
        manager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.println("Email: " + notification.getMessage()));
        manager.registerHandler(NotificationType.SMS, notification ->
                System.out.println("SMS: " + notification.getMessage()));
        manager.registerHandler(NotificationType.PUSH, notification ->
                System.out.println("Push: " + notification.getMessage()));

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
        System.out.println("with function : \n");
        manager.notificationWithDescription(emailNotification);
        manager.notificationWithDescription(smsNotification);
    }
}
