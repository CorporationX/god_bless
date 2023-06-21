package faang.school.godbless.meta;

public class Application {
    public static void main(String... args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

// Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

// Фильтрация слов в оповещении
        NoticeManager noticeManager = new NoticeManager();

        noticeManager.registerHand("Message", notification -> {
            if (notification.getMessage().contains("fuck")) {
                notification.setMessage(notification.getMessage().replace("fuck", "***"));
            }
            System.out.println(notification.getMessage());
            return notification;
        });

        Notification message = new Notification("Message", "I don't give a fuck");

        noticeManager.sendFilteredNotification(message);
        System.out.println(message.getMessage());
    }
}
