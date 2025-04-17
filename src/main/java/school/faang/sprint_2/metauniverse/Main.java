package school.faang.sprint_2.metauniverse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> log.info("Email {}", notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> log.info("Push {}", notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> log.info("SMS {}", notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован.");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен stupid.");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.registerBadWord(notification -> notification.getMessage().contains("dull"));
        notificationManager.registerBadWord(notification -> notification.getMessage().contains("moron"));
        notificationManager.registerBadWord(notification -> notification.getMessage().contains("stupid"));

        notificationManager.registerCorrection(notification ->
                new Notification(notification.getType(), notification.getMessage() + " from Boss"));

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
