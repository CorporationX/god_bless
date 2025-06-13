package school.faang.bjs280619;

import school.faang.bjs280619.Notification.NotificationType;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage()));

        notificationManager.addFilter(NotificationType.EMAIL,
                notification -> notification.getMessage().length() <= 10);
        notificationManager.addFilter(NotificationType.SMS,
                notification -> notification.getMessage().toLowerCase().contains("пароль"));
        notificationManager.addFilter(NotificationType.PUSH,
                notification -> notification.getMessage().trim().isEmpty());

        notificationManager.addTransformer(NotificationType.EMAIL,
                notification -> new Notification(notification.getType(),
                        notification.getMessage() + " | Sent by Meta"));
        notificationManager.addTransformer(NotificationType.SMS,
                notification -> {
                    String message = notification.getMessage();
                    if (message.length() > 50) {
                        message = message.substring(0, 47) + "...";
                    }
                    return new Notification(notification.getType(), message);
                });
        notificationManager.addTransformer(NotificationType.PUSH,
                notification -> new Notification(notification.getType(),
                        "[" + java.time.LocalDateTime.now().toString().substring(0, 8)
                                + "] " + notification.getMessage()));

        Notification shortEmail = new Notification(NotificationType.EMAIL, "Hi");
        Notification longSms = new Notification(NotificationType.SMS,
                "Очень длинное сообщение которое должно быть сокращено системой");
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(shortEmail);
        notificationManager.sendNotification(longSms);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
