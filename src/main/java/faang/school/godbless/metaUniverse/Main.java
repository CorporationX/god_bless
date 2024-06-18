package faang.school.godbless.metaUniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация фильтров
        notificationManager.registerFilter(notification -> {
            if (notification.message.contains("неприемлемый контент")) {
                return new Notification(notification.type, notification.message.replace("неприемлемый контент", "***"));
            }
            return notification;
        });

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", notification -> System.out.println("Отправка по электронной почте: " + notification.message));
        notificationManager.registerHandler("sms", notification -> System.out.println("Отправка SMS: " + notification.message));
        notificationManager.registerHandler("push", notification -> System.out.println("Отправка push-уведомления: " + notification.message));

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification inappropriateNotification = new Notification("push", "Это неприемлемый контент");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(inappropriateNotification);
    }
}
