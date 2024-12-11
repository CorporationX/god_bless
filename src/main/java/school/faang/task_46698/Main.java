package school.faang.task_46698;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final NotificationManager notificationManager = new NotificationManager();

    public static void main(String[] args) {
        initData();

        Notification emailNotification = new Notification(NotificationType.EMAIL,
                "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(NotificationType.SMS,
                "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(NotificationType.PUSH,
                "Новый пост от пользователя: JohnDoe");


        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }

    private static void initData() {
        notificationManager.registerHandler(NotificationType.EMAIL,
                (notification) -> log.info("Отправка по электронной почте: {}", notification.message())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                (notification) -> log.info("Отправка SMS: {}", notification.message())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                (notification) -> log.info("Отправка push-уведомления: {}", notification.message())
        );
    }

}
