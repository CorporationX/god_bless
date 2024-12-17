package school.faang.sprint2task46878;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationTyp.EMAIL,
                (notification) -> System.out.println("Отправка по электронной почте: "
                        + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationTyp.SMS,
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationTyp.PUSH,
                (notification) -> System.out.println("Отправка push-уведомления: "
                        + notification.getMessage())
        );

        Notification emailNotification = new Notification(NotificationTyp.EMAIL,
                "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(NotificationTyp.SMS,
                "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(NotificationTyp.PUSH,
                "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}