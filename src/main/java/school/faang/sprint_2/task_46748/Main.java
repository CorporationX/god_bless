package school.faang.sprint_2.task_46748;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler(NotificationType.EMAIL,
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.message())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                (notification) -> System.out.println("Отправка SMS: " + notification.message())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.message())
        );

        // Отправка оповещений
        Notification emailNotification = new Notification(
                NotificationType.EMAIL,
                "Ваша учетная запись успешно активирована"
        );
        Notification smsNotification = new Notification(
                NotificationType.SMS,
                "Вы успешно изменили свой пароль"
        );
        Notification pushNotification = new Notification(
                NotificationType.PUSH,
                "Новый пост от пользователя: JohnDoe"
        );

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
