package task_BJS2_57697;

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
        System.out.println();

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.addSignature(emailNotification, notification -> {
            notification.setMessage(emailNotification.getMessage() + emailNotification.getSignature());
            return notification;
        });
        notificationManager.addSignature(smsNotification, notification -> {
            notification.setMessage(smsNotification.getMessage() + emailNotification.getSignature());
            return notification;
        });
        notificationManager.addSignature(pushNotification, notification -> {
            notification.setMessage(pushNotification.getMessage() + emailNotification.getSignature());
            return notification;
        });

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
