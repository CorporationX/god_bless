package school.faang.bjs2_91602;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Runner {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerFilters();
        notificationManager.registerHandler(NotificationType.EMAIL, notification ->
                log.info("{}: {}", NotificationType.EMAIL.name(), notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS, notification ->
                log.info("{}: {}", NotificationType.SMS, notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                log.info("{}: {}", NotificationType.PUSH, notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification badPushNotification = new Notification(NotificationType.PUSH, "НЕЦЕНЗУРНАЯ ЛЕКСИКА");
        Notification memNotification = new Notification(NotificationType.MEM, "Check new memes!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(memNotification);
        notificationManager.sendNotification(badPushNotification);

    }
}