package school.faang.meta;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.printf(" Email" + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                System.out.printf(" Email" + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS, notification ->
                System.out.printf(" Email" + notification.getMessage()));

        Notification notificationEmail = new Notification(NotificationType.EMAIL, "Аккаунт активирован плохо");
        Notification notificationSms = new Notification(NotificationType.SMS, "пароль изменен");
        Notification notificationPush = new Notification(NotificationType.PUSH, "Новое сообщение");

        log.info(notificationManager.sendNotification(notificationEmail));
        log.info(notificationManager.sendNotification(notificationSms));
        log.info(notificationManager.sendNotification(notificationPush));
    }
}
