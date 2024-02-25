package faang.school.godbless.meta;

public class Main {
    public static void main(String... args) {

        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

// Отправка оповещений
        faang.school.godbless.meta.Notification emailNotification = new faang.school.godbless.meta.Notification("email", "Ваша учетная запись успешно активирована");
        faang.school.godbless.meta.Notification smsNotification = new faang.school.godbless.meta.Notification("sms", "Вы успешно изменили свой пароль");
        faang.school.godbless.meta.Notification pushNotification = new faang.school.godbless.meta.Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}