package school.faang.task_46711;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.message()));

        notificationManager.registerHandler(NotificationType.SMS,
                (notification) -> System.out.println("Отправка SMS: " + notification.message())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.message())
        );

        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification(NotificationType.EMAIL, "Ваша учетная запись успешно активирована"));
        notifications.add(new Notification(NotificationType.SMS, "Вы успешно изменили свой пароль"));
        notifications.add(new Notification(NotificationType.PUSH, "Новый пост от пользователя: JohnDoe"));

        notifications.forEach(notificationManager::sendNotification);
    }
}
