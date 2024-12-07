package school.faang.task46593;

import static school.faang.task46593.TypeOfNotification.*;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(EMAIL, notification ->
                System.out.println("Отправка по электронной почте:" + notification.getMessage()));

        notificationManager.registerHandler(INFORMATION,
                (notification) -> System.out.println("Отправка информации: " + notification.getMessage())
        );

        Notification emailNotification = new Notification(EMAIL,
                "Ваша учетная запись успешно активирована!");

        Notification informationNotification = new Notification(INFORMATION,
                "Вам был одобрен кредит!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(informationNotification);
    }
}
