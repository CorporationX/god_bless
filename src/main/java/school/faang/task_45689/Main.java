package school.faang.task_45689;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotifyType.EMAIL,
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.message())
        );

        notificationManager.registerHandler(NotifyType.SMS,
                (notification) -> System.out.println("Отправка SMS: " + notification.message())
        );

        notificationManager.registerHandler(NotifyType.PUSH,
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.message())
        );

        // Отправка оповещений
        Notification emailNotification = new Notification(NotifyType.EMAIL, "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(NotifyType.SMS, "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(NotifyType.PUSH, "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
