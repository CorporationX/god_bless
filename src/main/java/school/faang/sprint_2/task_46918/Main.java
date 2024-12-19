package school.faang.sprint_2.task_46918;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification callNotification = new Notification("call", "Пропущенный вызов");

        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification("email", "Ваша учетная запись успешно активирована"));
        notificationList.add(new Notification("sms", "Вы успешно изменили свой пароль"));
        notificationList.add(new Notification("call", "Пропущенный вызов"));
        notificationList.add(new Notification("push", "Новый пост от пользователя: JohnDoe"));

        notificationList.forEach(notificationManager::sendNotification);
    }
}
