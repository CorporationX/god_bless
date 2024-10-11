package school.faang.BJS234742;

import school.faang.BJS234742.dto.Notification;
import school.faang.BJS234742.service.NotificationManager;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = getNotificationManager();

        // Отправка оповещений
        Notification emailNotification
                = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }

    private static NotificationManager getNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email",
                (notification) -> System.out.printf("Отправка по электронной почте: %s.%n",
                        notification.getMessage().toLowerCase()));

        notificationManager.registerHandler("sms",
                (notification) -> System.out.printf("Отправка %s-уведомления: %s!%n",
                        notification.getType().toUpperCase(),
                        notification.getMessage().toUpperCase()));

        notificationManager.registerHandler("push",
                (notification) -> System.out.printf("Отправка %s-уведомления: %s.%n",
                        notification.getType(),
                        notification.getMessage()));
        return notificationManager;
    }
}
