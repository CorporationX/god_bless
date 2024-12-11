package school.faang.bjs246738;

public class TestFunctionality {
    public static void test() {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(Enums.NotificationType.EMAIL,
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler(Enums.NotificationType.SMS,
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(Enums.NotificationType.PUSH,
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        Notification emailNotification = new Notification(Enums.NotificationType.EMAIL, "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(Enums.NotificationType.SMS, "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(Enums.NotificationType.PUSH, "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
