package school.faang.BJS2_34767;


public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваша учетная запись успешно активирована");
        Notification emailNotificationWithForbiddenWord =
                new Notification(NotificationType.EMAIL, "дурак , глупый и еще раз дурак");
        Notification smsNotification = new Notification(NotificationType.SMS, "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(emailNotificationWithForbiddenWord);
    }
}
