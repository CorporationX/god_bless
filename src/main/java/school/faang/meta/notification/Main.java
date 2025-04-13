package school.faang.meta.notification;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS to admin: " + notification.getMessage()));

        notificationManager.addForwardRule(notification ->
                notification.getType() == NotificationType.SMS && notification.getMessage().length() > 50
                        ? Optional.of(NotificationType.EMAIL)
                        : Optional.empty()
        );

        notificationManager.addFilterRule(NotificationType.SMS,
                notification -> !notification.getMessage().toLowerCase().contains("пин-код"));

        notificationManager.addEditMessageRule(NotificationType.EMAIL,
                notification -> new Notification(notification.getType(), notification.getMessage().toUpperCase()));
        notificationManager.addEditMessageRule(NotificationType.EMAIL, notification ->
                new Notification(notification.getType(), "ВНИМАНИЕ! " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Карта активирована");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пин-Код изменен");
        Notification smsNotificationLenghtOver = new Notification(NotificationType.SMS, "SMS->EMAIL ".repeat(25));
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое поступление");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(smsNotificationLenghtOver);
        notificationManager.sendNotification(pushNotification);

        notificationManager.printStatistics();
    }
}
