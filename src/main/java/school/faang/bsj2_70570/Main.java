package school.faang.bsj2_70570;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        // Не экстракчу, тк это довольно маленький блок кода. Будет больше - непременно заэкстрактил бы.
        notificationManager.registerHandler(NotificationType.EMAIL,
                handler -> System.out.println("Email: " + handler.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                handler -> System.out.println("Push: " + handler.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                handler -> System.out.println("SMS: " + handler.getMessage()));

        // Как вынести это в переменную догадался только при решении следующей задачи.
        Predicate<Notification> isProfane = profanityHandler -> {
            if (profanityHandler.getMessage().equals("Curse")) {
                System.out.println(profanityHandler.getType() + " contained profanity and was not sent");
                return true;
            }
            return false;
        };

        notificationManager.registerProfanityFilter(NotificationType.EMAIL, isProfane);
        notificationManager.registerProfanityFilter(NotificationType.SMS, isProfane);
        notificationManager.registerProfanityFilter(NotificationType.PUSH, isProfane);

        notificationManager.registerMessageChanger(NotificationType.EMAIL,
                notification -> {
                    notification.setMessage(notification.getMessage() + ". respond at roga&kopyta@gmail.com");
                    return notification;
                });

        notificationManager.registerMessageChanger(NotificationType.SMS,
                notification -> {
                    notification.setMessage(notification.getMessage() + ". call us! 899999999");
                    return notification;
                });


        List<Notification> notificationList = List.of(
                new Notification(NotificationType.EMAIL, "You've got mail"),
                new Notification(NotificationType.PUSH, "You've got push-notification"),
                new Notification(NotificationType.SMS, "You've got sms-notification"),
                new Notification(NotificationType.EMAIL, "Curse"),
                new Notification(NotificationType.SMS, "Curse"),
                new Notification(NotificationType.PUSH, "Curse"));



        for (Notification notification : notificationList) {
            if ((notification.getType() == NotificationType.EMAIL || notification.getType() == NotificationType.SMS)
                && !notificationManager.sendProfanityNotification(notification)) {
                notificationManager.changeNotificationMessage(notification);
                notificationManager.sendNotification(notification);
            }
            if (notification.getType() == NotificationType.PUSH
                && !notificationManager.sendProfanityNotification(notification)) {
                notificationManager.sendNotification(notification);
            }
        }
    }
}
