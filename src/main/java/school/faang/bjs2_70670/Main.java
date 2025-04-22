package school.faang.bjs2_70670;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerPrefixHandlers(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerPrefixHandlers(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerPrefixHandlers(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        String jegorSignature = "@JegorKuz";
        notificationManager.registerSignatureHandlers(jegorSignature,
                notification -> new Notification(notification.getType(),
                        notification.getMessage() + " | " + jegorSignature)
        );

        String vladSignature = "@Vlad";
        notificationManager.registerSignatureHandlers(vladSignature,
                notification -> new Notification(notification.getType(),
                        notification.getMessage() + " | " + vladSignature)
        );

        notificationManager.registerTypeCheckHandlers(NotificationType.EMAIL,
                notification -> notification.getType() == NotificationType.EMAIL);

        notificationManager.registerTypeCheckHandlers(NotificationType.SMS,
                notification -> notification.getType() == NotificationType.SMS);

        notificationManager.registerExceptionHandlers(NotificationType.EMAIL,
                (notification, isEmail) -> {
                    if (isEmail.test(notification)) {
                        return new Notification(notification.getType(), "Email is currently not supported");
                    }
                    return notification;
                });

        notificationManager.registerExceptionHandlers(NotificationType.PUSH,
                (notification, isExceptionType) -> {
                    if (isExceptionType.test(notification)) {
                        return new Notification(notification.getType(), "PUSH is currently not supported");
                    }
                    return notification;
                });

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        String randomSignature = "@Random";
        notificationManager.sendNotification(emailNotification, jegorSignature);
        notificationManager.sendNotification(emailNotification, vladSignature);
        notificationManager.sendNotification(emailNotification, randomSignature);

        notificationManager.sendNotification(smsNotification, jegorSignature);
        notificationManager.sendNotification(smsNotification, vladSignature);
        notificationManager.sendNotification(smsNotification, randomSignature);

        notificationManager.sendNotification(pushNotification, jegorSignature);
        notificationManager.sendNotification(pushNotification, vladSignature);
        notificationManager.sendNotification(pushNotification, randomSignature);
    }
}
