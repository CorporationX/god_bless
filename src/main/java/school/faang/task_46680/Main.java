package school.faang.task_46680;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        registerHandler(notificationManager);
        sendNotification(notificationManager);
    }

    private static void sendNotification(NotificationManager notificationManager) {
        List<Notification> notifications = new ArrayList<>();

        addNotifications(notifications);
        checkNotifications(notifications, notificationManager);
        sendNotificationUsers(notifications, notificationManager);
    }

    private static void sendNotificationUsers(List<Notification> notifications, NotificationManager
            notificationManager) {
        notifications.forEach(notification -> notificationManager.sendNotification(notification));
    }

    private static void checkNotifications(List<Notification> notifications, NotificationManager notificationManager) {
        List<Notification> toDelete = new ArrayList<>();
        notifications.forEach(notification -> {
            boolean isDeleteNotification = notificationManager
                    .isDeleteNotification(notification);
            if (isDeleteNotification) {
                toDelete.add(notification);
            }
        });
        notifications.removeAll(toDelete);
    }

    private static void addNotifications(List<Notification> notifications) {
        notifications.add(new Notification("email", "Ваша учетная запись успешно активирована"));
        notifications.add(new Notification("sms", "Вы успешно изменили свой пароль"));
        notifications.add(new Notification("push", "Новый пост от пользователя: JohnDoe"));
        notifications.add(new Notification("blocked", "Учетная запись заблокирована"));
        notifications.add(new Notification("email", "Купите алкоголь и никотин!"));
        notifications.add(new Notification("email", "Закупил оружие у Иваныча. Приходи тестировать."));
    }

    private static void registerHandler(NotificationManager notificationManager) {
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

    }
}
