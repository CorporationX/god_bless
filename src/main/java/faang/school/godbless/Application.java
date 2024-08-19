package faang.school.godbless;

import java.util.function.Consumer;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
        NotificationManager notificationManager = new NotificationManager();
        Consumer<Notification> consumer = System.out::println;
        Consumer<Notification> consumer2 =(notification) -> {
            System.out.println("Отправка SMS: " + notification.getMessage());
        };
// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", consumer);
        notificationManager.registerHandler("sms", consumer2);
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

// Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}