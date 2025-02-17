package school.faang.task_57907;

import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL,
                "Ваш аккаунт, черт бы его побрал, активирован.");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен.");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.registerFilter(NotificationFilterType.OBSCENE,
                notification -> {
                    Matcher matcher = Notification.OBSCENE_WORDS_PATTERN.matcher(notification.getMessage());
                    return (!matcher.find());
                });

        if (notificationManager.isCorrectNotification(emailNotification, NotificationFilterType.OBSCENE)) {
            notificationManager.sendNotification(emailNotification);
        } else {
            System.out.println("Уведомление содержит нецензурную лексику!");
        }

        notificationManager.registerCorrector(NotificationCorrectorType.SIGNATURE,
                notification -> {
                    notification.setMessage(notification.getMessage() + notification.getSignature());
                    return notification;
                });
        smsNotification = notificationManager.adjustNotification(smsNotification, NotificationCorrectorType.SIGNATURE);
        notificationManager.sendNotification(smsNotification);
    }
}
