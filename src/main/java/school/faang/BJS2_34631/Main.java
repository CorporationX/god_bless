package school.faang.BJS2_34631;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        notificationManager.registerCensure("spamFilter",
                notification -> notification.getMessage().toLowerCase().contains("spam"));

        Notification emailNotification = new Notification("email",
                "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("smss",
                "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push",
                "Новый пост от пользователя: JohnDoe");
        Notification spamNotification = new Notification("sms",
                "spam! Купите дешевые часы!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(spamNotification);
    }
}
