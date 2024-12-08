package school.faang.sprint2.task_46640;

import static school.faang.sprint2.task_46640.NotificationType.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(EMAIL,
                (notification) -> log.info("Отправка по электронной почте: " + notification.getMessage())
        );
        notificationManager.registerHandler(SMS,
                (notification) -> log.info("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler(PUSH,
                (notification) -> log.info("Отправка push-уведомления: " + notification.getMessage())
        );
        notificationManager.registerHandler(TELEGRAM,
                notification -> log.info("Отправка telegram уведомления: " + notification.getMessage()));

        Notification emailNotification = new Notification(EMAIL, "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(SMS, "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(PUSH, "Новый пост от пользователя: JohnDoe");
        Notification telegramNotification = new Notification(TELEGRAM, "Ваш код для авторизации: 943121");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(telegramNotification);
    }
}
