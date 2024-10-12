package metaCosmos;


public class Main {

    public static void main(String... args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                notification -> System.out.println("Отправка по email " + notification.getMessage()));

        notificationManager.registerHandler("sms",
                notification -> System.out.println("Отправка sms " + notification.getMessage()));

        notificationManager.registerHandler("push",
                notification -> System.out.println("Отправка push-уведомления " + notification.getMessage()));

        Notification emailNotification = new Notification("email",
                "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms",
                "Вы успешно обновили свой пароль");
        Notification pushNotification = new Notification("push",
                "Новй пост от пользователя: John Doe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

    }
}
