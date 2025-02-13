package task_BJS2_57697;

public class Main {
    public static void main(String[] args) {

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + emailNotification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + smsNotification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + pushNotification.getMessage())
        );
        System.out.println();

        notificationManager.addSignature(emailNotification, notificationManager::putSignature);
        notificationManager.addSignature(smsNotification, notificationManager::putSignature);
        notificationManager.addSignature(pushNotification, notificationManager::putSignature);

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
