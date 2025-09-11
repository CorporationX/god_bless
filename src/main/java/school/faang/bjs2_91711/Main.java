package school.faang.bjs2_91711;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws Exception {
        //Test:
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("EMAIL: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("PUSH: " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Вам пришло письмо.");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пришло sms-сообщение.");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Вам пришло push-уведомление.");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
