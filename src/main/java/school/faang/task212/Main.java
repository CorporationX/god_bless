package school.faang.task212;

import school.faang.task212.notifications.Notification;
import school.faang.task212.notifications.NotificationManager;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Notification emailNotification = new Notification("email", "Your account has been successfully activated");
        Notification smsNotification = new Notification("sms", "You have successfully  changed your password");
        Notification pushNotification = new Notification("push", "New post thirdbadword from user: JohnDoe");

        Set<String> badWords = Set.of("firstbadword", "secondbadword", "thirdbadword");
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(emailNotification.getType(),
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );
        notificationManager.registerHandler(smsNotification.getType(),
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler(pushNotification.getType(),
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        notificationManager.sendNotification(badWords, emailNotification);
        notificationManager.sendNotification(badWords, smsNotification);
        notificationManager.sendNotification(badWords, pushNotification);
    }
}
