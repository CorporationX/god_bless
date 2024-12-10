package school.faang.task_46701;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        try {
//            NotificationManager notificationManager = new NotificationManager();
            NotificationManager manager = new NotificationManager();
//
//            notificationManager.registerHandler("email",
//                    (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
//            );
//
//            notificationManager.registerHandler("sms",
//                    (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
//            );
//
//            notificationManager.registerHandler("push",
//                    (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
//            );
//
//            notificationManager.sendNotification(new Notification("email", "Ваша учетная запись успешно активирована"));
//            notificationManager.sendNotification(new Notification("sms", "Вы успешно изменили свой пароль"));
//            notificationManager.sendNotification(new Notification("push", "Новый пост от пользователя: JohnDoe"));

            manager.registerHandler("email", notification -> System.out.println("Email notification: " + notification.getMessage()));
            manager.registerHandler("sms", notification -> System.out.println("SMS notification: " + notification.getMessage()));
            manager.registerHandler("push", notification -> System.out.println("Push notification: " + notification.getMessage()));

            // Регистрация фильтров
            manager.registerFilter("email", notification -> notification.getMessage().contains("spam"));
            manager.registerFilter("sms", notification -> notification.getMessage().length() < 160);
            // Регистрация корректоров
            manager.registerCorrector("push", notification -> new Notification(notification.getType(), notification.getMessage().toUpperCase()));
            // Отправка различных оповещений
            manager.sendNotification(new Notification("email", "This is a spam email"));
            manager.sendNotification(new Notification("sms", "This SMS message is too long for a single SMS message and should be filtered out"));
            manager.sendNotification(new Notification("push", "This is a push notification"));
            // Демонстрация использования функции логирования
            Consumer<Notification> logger = notification -> System.out.println("Logged notification: " + notification);
            manager.registerHandler("log", logger);
            manager.sendNotification(new Notification("log", "This notification should be logged"));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
