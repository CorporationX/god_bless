package school.faang.sprint_2.task_46602;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = getNotificationManager();
        List<Notification> listNotification = new ArrayList<>(
                Arrays.asList(
                        new Notification("email", "Ваша учетная запись успешно активирована"),
                        new Notification("sms", "Вы успешно изменили свой пароль"),
                        new Notification("push", "Новый пост от пользователя: JohnDoe"),
                        new Notification("Scam", "Алло это служба безопасности сбербанка")
                        )
        );

        for (Notification notification : listNotification) {
            notificationManager.sendNotification(notification);
        }
    }

    private static NotificationManager getNotificationManager() {
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
        return notificationManager;
    }
}