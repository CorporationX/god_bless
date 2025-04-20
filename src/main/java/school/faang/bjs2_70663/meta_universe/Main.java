package school.faang.bjs2_70663.meta_universe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account is activated!");
        try {
            notificationManager.sendNotification(emailNotification);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> log.info("Email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> log.info("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> log.info("PUSH: " + notification.getMessage()));

        Notification smsNotification = new Notification(NotificationType.SMS, "Your password is changed to ass!");
        Notification pushNotification = new Notification(NotificationType.PUSH, "You have a new message!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);

        notificationManager.addFooterHandler(notification -> {
            notification.setMessage(notification.getMessage() + "\nSincerely,\n" + "Meta Team");
            return notification;
        });
        Notification pushNotification2 = new Notification(NotificationType.PUSH, "You have another new message!");

        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(pushNotification2);

        notificationManager.addFilter(notification -> notification.getMessage().contains("fuck"));
        notificationManager.addFilter(notification -> notification.getMessage().contains("ass"));

        try {
            notificationManager.sendNotification(smsNotification);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }
    }
}
