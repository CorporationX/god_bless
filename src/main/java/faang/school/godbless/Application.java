package faang.school.godbless;

import java.util.function.Consumer;
import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", notification -> System.out.println("Notification by email: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println("Notification by SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification -> System.out.println("Notification by push: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}