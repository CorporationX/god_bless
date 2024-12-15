package school.faang.sprint_2.task_43535;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Отправка email: " + notification.message()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("Отправка SMS: " + notification.message()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Отправка push-уведомления: " + notification.message()));

        Notification emailNotification = new Notification(NotificationType.EMAIL,
                "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(NotificationType.SMS,
                "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(NotificationType.PUSH,
                "Новый пост от пользователя: Lololowka");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}

