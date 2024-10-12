package school.faang.BJS2_34751;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHendler("email",
            (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHendler("sms",
            (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHendler("push",
            (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

// Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotifycation(emailNotification);
        notificationManager.sendNotifycation(smsNotification);
        notificationManager.sendNotifycation(pushNotification);
    }
}
