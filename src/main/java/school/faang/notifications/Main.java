package school.faang.notifications;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerNotification("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerNotification("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerNotification("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        notificationManager.registerNotification("warring",
                (notification) -> System.out.println("Отправка предупреждения: " + notification.getMessage())
        );

        notificationManager.registerFilter("warring",
                (message) -> message.contains("error"));

// Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification warringNotificationRussia = new Notification("warring", "Пожалуйса подтвердите почту");
        Notification warringNotificationTEnglish = new Notification("warring", "Error -> confirm email");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(warringNotificationRussia);
        notificationManager.sendNotification(warringNotificationTEnglish);
    }
}
