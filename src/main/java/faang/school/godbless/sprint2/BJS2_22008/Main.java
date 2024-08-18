package faang.school.godbless.sprint2.BJS2_22008;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        notificationManager.registerHandler("log", (notification) -> {
            System.out.println("Log notification: " + notification.getMessage());
        });
// Отправка оповещений
        Notification logNotification = new Notification("log", "Server started at " + Timestamp.valueOf(LocalDateTime.now()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification uncensoredNotification = new Notification("sms", "Alarm, badword");

        Predicate<Notification> containsInappropriateContent = notification -> notification.getMessage().contains("badword");
        Consumer<Notification> censorNotification = notification -> {
            String censoredMessage = notification.getMessage().replace("badword", "****");
            System.out.println("Censored message: " + censoredMessage);
        };
        notificationManager.addFilter(containsInappropriateContent, censorNotification);

        notificationManager.sendNotification(logNotification);
        notificationManager.sendNotification(uncensoredNotification);

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
