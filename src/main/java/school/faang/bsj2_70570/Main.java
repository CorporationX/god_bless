package school.faang.bsj2_70570;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager =
                new NotificationManager(new HashMap<>(), new HashMap<>(), new HashMap<>());
        notificationManager.registerHandler(NotificationType.EMAIL,
                handler -> System.out.println("Email: " + handler.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                handler -> System.out.println("Push: " + handler.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                handler -> System.out.println("SMS: " + handler.getMessage()));
        notificationManager.registerProfanityFilter(NotificationType.EMAIL,
                handler -> {
                    if (handler.getMessage().equals("Curse")) {
                        System.out.println(handler.getMessage() + " contained profanity and was not sent");
                        return true;
                    }
                    return false;
                });
        notificationManager.registerProfanityFilter(NotificationType.SMS,
                handler -> {
                    if (handler.getMessage().equals("Curse")) {
                        System.out.println(handler.getType() + " contained profanity and was not sent");
                        return true;
                    }
                    return false;
                });
        notificationManager.registerProfanityFilter(NotificationType.PUSH,
                handler -> {
                    if (handler.getMessage().equals("Curse")) {
                        System.out.println(handler.getType() + " contained profanity and was not sent");
                        return true;
                    }
                    return false;
                });

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

/*
Push-уведомления специально оставил без реализации, чтобы лишний раз попрактиковаться в логике.
 */