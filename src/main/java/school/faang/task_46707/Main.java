package school.faang.task_46707;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        var bannerWords = List.of("badWord1", "badWord2");

        notificationManager.registerHandler(NotificationType.EMAIL,
            (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );
        notificationManager.registerHandler(NotificationType.SMS,
            (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler(NotificationType.PUSH,
            (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        notificationManager.registerFilter(NotificationType.PUSH,
            notification -> bannerWords.stream().anyMatch(notification.getMessage()::contains)
        );

        Notification emailRegisterNotification = new Notification(NotificationType.EMAIL,
            "Ваша учетная запись успешно активирована");
        Notification smsPassNotification = new Notification(NotificationType.SMS,
            "Вы успешно изменили свой пароль");
        Notification pushPostNotification = new Notification(NotificationType.PUSH,
            "Новый пост от пользователя: JohnDoe");
        Notification pushBadWordNotification = new Notification(NotificationType.PUSH,
            "Сообщение содержит badWord1");

        notificationManager.sendNotification(emailRegisterNotification);
        notificationManager.sendNotification(smsPassNotification);
        notificationManager.sendNotification(pushPostNotification);
        notificationManager.sendNotification(pushBadWordNotification);
    }
}
