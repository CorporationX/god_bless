package bjs257936;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> LOGGER.info("Email: {}", notification.getMessage()),
                notificationType -> notificationType.equals(NotificationType.EMAIL));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> LOGGER.info("Sms: {}", notification.getMessage()),
                notificationType -> notificationType.equals(NotificationType.SMS));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> LOGGER.info("Push: {}", notification.getMessage()),
                notificationType -> notificationType.equals(NotificationType.PUSH));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Подтверждение регистрации");
        Notification smsNotification = new Notification(NotificationType.SMS, "Уведомление о зачислении");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Установлен новый тариф");

        notificationManager.sendNotification(emailNotification, Notification::getMessage);
        notificationManager.sendNotification(smsNotification, Notification::getMessage);
        notificationManager.sendNotification(pushNotification, Notification::getMessage);
    }
}
