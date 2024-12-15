package school.faang.task_46846;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler(Types.EMAIL,
                notification -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));

        notificationManager.registerHandler(Types.SMS,
                notification -> System.out.println("Отправка СМС: " + notification.getMessage()));

        notificationManager.registerHandler(Types.PUSH,
                notification -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        // Отправка оповещений
        Notification emailNotification = new Notification(Types.EMAIL, "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(Types.SMS, "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(Types.PUSH, "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
