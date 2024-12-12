package school.faang.bjs2x46888;

public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL.getNotificationType(),
                (notification) -> System.out.println("Отправка по электронной почте: "
                        + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS.getNotificationType(),
                (notification) -> System.out.println("Отправка SMS: "
                        + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH.getNotificationType(),
                (notification) -> System.out.println("Отправка push-уведомления: "
                        + notification.getMessage())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL.getNotificationType(),
                "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(NotificationType.SMS.getNotificationType(),
                "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(NotificationType.PUSH.getNotificationType(),
                "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}

