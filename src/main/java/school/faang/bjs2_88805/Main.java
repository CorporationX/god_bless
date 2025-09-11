package school.faang.bjs2_88805;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
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

        Function<Notification, Notification> correct = message ->
                new Notification(message.getType(), message.getMessage() + " Meta Inc.");

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification, correct);
        notificationManager.sendNotification(smsNotification, correct);
        notificationManager.sendNotification(pushNotification, correct);

        //Реализация фильтра
        Notification testBanWord = new Notification(NotificationType.EMAIL, "Плохое Слово");
        Notification testBanWordTwo = new Notification(NotificationType.EMAIL, "Плохое Слово 2");
        Notification testBanWordThree = new Notification(NotificationType.EMAIL, "Банан");
        Notification testBanNotificationThree = new Notification(NotificationType.EMAIL, "Норм сообщение");

        notificationManager.registerPredicateFilter(testBanWord.getType(), "Плохое Слово");
        notificationManager.registerPredicateFilter(testBanWordTwo.getType(), "Плохое Слово 2");
        notificationManager.registerPredicateFilter(testBanWordThree.getType(), "Банан");
        notificationManager.sendNotification(testBanWord, correct);
        notificationManager.sendNotification(testBanWordTwo, correct);
        notificationManager.sendNotification(testBanWordThree, correct);
        notificationManager.sendNotification(testBanNotificationThree, correct);


    }
}
