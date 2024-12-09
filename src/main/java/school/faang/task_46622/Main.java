package school.faang.task_46622;

import school.faang.task_46622.entity.Notification;
import school.faang.task_46622.entity.TypeNotification;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(TypeNotification.EMAIL,
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler(TypeNotification.SMS,
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(TypeNotification.PUSH,
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        Notification emailNotification = new Notification(TypeNotification.EMAIL,
                "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(TypeNotification.SMS, "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(TypeNotification.PUSH, "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
