package school.faang.task212;

import school.faang.task212.notifications.Notification;
import school.faang.task212.notifications.NotificationManager;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Notification emailNotification = new Notification("email", "Your account has been successfully activated");
        Notification smsNotification = new Notification("sms", "You have thirdbadword successfully  changed your password");
        Notification pushNotification = new Notification("push", "New post thirdbadword from user: JohnDoe");

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(emailNotification.getType(),
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );
        notificationManager.registerHandler(smsNotification.getType(),
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler(pushNotification.getType(),
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        boolean needCheck = true;
        boolean noNeededCheck = false;

        notificationManager.sendNotification(needCheck, emailNotification);
        notificationManager.sendNotification(needCheck, smsNotification);
        notificationManager.sendNotification(noNeededCheck, pushNotification);
    }
}
