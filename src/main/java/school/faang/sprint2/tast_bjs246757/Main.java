package school.faang.sprint2.tast_bjs246757;

public class Main {

    public static final String EMAIL = "email";
    public static final String SMS = "sms";
    public static final String PUSH = "push";

    public static void main(String[] args) {
        NotificationManager manager = getNotificationManager();
        manager.sendNotification(createNotification(EMAIL, "Ваша учетная запись успешно активирована"));
        manager.sendNotification(createNotification(SMS, "Вы успешно изменили свой пароль"));
        manager.sendNotification(createNotification(PUSH, "Новый пост от пользователя: JohnDoe"));
        manager.sendNotification(createNotification("NotExists", "Не существует"));
        manager.sendNotification(createNotification(null, null));
        manager.sendNotification(null);

    }

    private static Notification createNotification(String type, String message) {
        return new Notification(type, message);
    }

    private static NotificationManager getNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler(EMAIL,
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler(SMS,
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(PUSH,
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        notificationManager.registerHandler(null,
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        notificationManager.registerHandler(PUSH, null);
        return notificationManager;
    }
}
