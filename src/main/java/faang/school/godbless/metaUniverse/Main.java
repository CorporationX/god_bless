package faang.school.godbless.metaUniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification dangerous = new Notification("email", "Дарим бонус в размере 5 тысяч на ваш счет!");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(dangerous);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.addMessages(notification -> notification.getMessage().contains("бонус"));

        notificationManager.checkMessages(emailNotification);
        notificationManager.checkMessages(dangerous);
        notificationManager.checkMessages(smsNotification);
        notificationManager.checkMessages(pushNotification);

    }
}
