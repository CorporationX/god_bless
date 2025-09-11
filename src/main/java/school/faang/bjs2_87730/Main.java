package school.faang.bjs2_87730;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println(notification.getMessage()));
        notificationManager
                .sendNotification(new Notification(NotificationType.PUSH, "Для вас новое уведомление!"));
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println(notification.getMessage()));
        notificationManager
                .sendNotification(new Notification(NotificationType.EMAIL,
                        "Чтобы зарегистрироваться на сайте, подтвердите почту"));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println(notification.getMessage()));
        notificationManager
                .sendNotification(new Notification(NotificationType.SMS, "Антон: Пошли на рыбалку)"));
        System.out.println("---------------------------------------");
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println(notification.getMessage()));
        Notification notificationAfterCorrection = notificationManager
                .addDateToNotificationMessage(new Notification(NotificationType.EMAIL, "Hello World!!!"),
                        notification -> {
                            notification.setMessage(String.format("%tT -> %s",
                                    LocalTime.now(),
                                    notification.getMessage()));
                            return notification;
                        });
        notificationManager.sendNotification(notificationAfterCorrection);
    }
}
