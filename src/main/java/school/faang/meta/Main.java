package school.faang.meta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(Main.class);

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.println(" Email" + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                System.out.println(" Email" + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS, notification ->
                System.out.println(" Email" + notification.getMessage()));

        Notification notificationEmail = new Notification(NotificationType.EMAIL, "Аккаунт активирован плохо");
        Notification notificationSms = new Notification(NotificationType.SMS, "пароль изменен");
        Notification notificationPush = new Notification(NotificationType.PUSH, "Новое сообщение");

        logger.info(notificationManager.sendNotification(notificationEmail));
        logger.info(notificationManager.sendNotification(notificationSms));
        logger.info(notificationManager.sendNotification(notificationPush));
    }
}
