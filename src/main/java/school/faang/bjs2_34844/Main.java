package school.faang.bjs2_34844;

import school.faang.bjs2_34844.service.Notification;
import school.faang.bjs2_34844.service.NotificationManager;
import school.faang.bjs2_34844.service.TypeNotification;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(TypeNotification.PUSH,
                notification -> System.out.println(TypeNotification.PUSH.getActionMessage() + notification.getMessage()));
        notificationManager.registerHandler(TypeNotification.EMAIL,
                notification -> System.out.println(TypeNotification.EMAIL.getActionMessage() + notification.getMessage()));
        notificationManager.registerHandler(TypeNotification.SMS,
                notification -> System.out.println(TypeNotification.SMS.getActionMessage() + notification.getMessage()));

        Notification emailNotification = new Notification(TypeNotification.EMAIL, "Your order has been successfully placed");
        Notification smsNotification = new Notification(TypeNotification.SMS, "Your verification code is: 1234");
        Notification pushNotification = new Notification(TypeNotification.PUSH, "You have a new comment from user: JaneDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

    }
}
