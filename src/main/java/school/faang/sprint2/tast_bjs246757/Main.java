package school.faang.sprint2.tast_bjs246757;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = getNotificationManager();
        manager.sendNotification(createNotification("email", "Ваша учетная запись успешно активирована"));
        manager.sendNotification(createNotification("sms", "Вы успешно изменили свой пароль"));
        manager.sendNotification(createNotification("push", "Новый пост от пользователя: JohnDoe"));
        manager.sendNotification(createNotification("NotExists", "Не существует"));

    }

    private static Notification createNotification(String type, String message) {
        return new Notification(type, message);
    }

    private static NotificationManager getNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );
        return notificationManager;
    }
}
