package school.faang.notifications;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerNotificationHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerNotificationHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerNotificationHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        notificationManager.registerNotificationHandler("warring",
                (notification) -> System.out.println("Отправка предупреждения: " + notification.getMessage())
        );

        notificationManager.registerFilter("warring",
                (message) -> message.contains("error")
        );

        notificationManager.registerFilter("error",
                (message) -> message.contains("info")
        );

        notificationManager.registerCorrectiveNotificationsHandlers("warring",
                (notification) -> {
                    String correctedMessage = notification.getMessage()
                            .toLowerCase()
                            .replaceAll("error", "warring");
                    return new Notification(notification.getType(), correctedMessage);
        });

// Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification warringNotificationRussia = new Notification("warring", "Пожалуйса подтвердите почту");
        Notification warringNotificationTEnglish = new Notification("warring", "Error -> confirm email");
        Notification errorNotification = new Notification("error", "info -> невыерный пароль");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(warringNotificationRussia);
        notificationManager.sendNotification(warringNotificationTEnglish);
        notificationManager.sendNotification(errorNotification);
    }
}
