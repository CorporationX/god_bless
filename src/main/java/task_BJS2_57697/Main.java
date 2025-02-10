package task_BJS2_57697;

import java.util.Map;
import java.util.function.Consumer;

import static task_BJS2_57697.NotificationType.SMS;

public class Main {
    public static void main(String[] args) {
        //Notification sms = new Notification(SMS, "на твой телефон пришло новое сообщение");
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

    }
}
