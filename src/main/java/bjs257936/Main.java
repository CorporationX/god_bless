package bjs257936;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> LOGGER.info("Email: {}", notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> LOGGER.info("Sms: {}", notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> LOGGER.info("Push: {}", notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Подтверждение регистрации");
        Notification smsNotification = new Notification(NotificationType.SMS, "Уведомление о зачислении");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Установлен новый тариф");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
