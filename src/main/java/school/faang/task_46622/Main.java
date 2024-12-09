package school.faang.task_46622;

import school.faang.task_46622.entity.Notification;
import school.faang.task_46622.entity.TypeNotification;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(TypeNotification.EMAIL,
                (notification) -> System.out.println("Sending via email: " + notification.getMessage())
        );
        notificationManager.registerHandler(TypeNotification.SMS,
                (notification) -> System.out.println("Sending via SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler(TypeNotification.PUSH,
                (notification) -> System.out.println("Sending a push notification: " + notification.getMessage())
        );

        List<Notification> notifications = getNotifications();

        for (Notification notification : notifications) {
            notificationManager.sendNotification(notification);
        }
    }

    private static List<Notification> getNotifications() {
        Notification emailNotification = new Notification(TypeNotification.EMAIL,
                "Your account has been successfully activated");
        Notification smsNotification = new Notification(TypeNotification.SMS,
                "You have successfully changed your password");
        Notification pushNotification = new Notification(TypeNotification.PUSH,
                "New post from user: JohnDoe");
        return List.of(emailNotification, smsNotification, pushNotification);
    }


}
