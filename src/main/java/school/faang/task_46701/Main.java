package school.faang.task_46701;

public class Main {
    public static void main(String[] args) {
        try {
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

            notificationManager.registerFilter("email", notification -> !notification.getMessage().contains("spam"));
            notificationManager.registerFilter("sms", notification -> notification.getMessage().length() < 20);

            notificationManager.registerCorrector("push", notification -> new Notification(notification.getType(), notification.getMessage().toUpperCase()));

//            notificationManager.sendNotification(new Notification("email", "Этот email - spam"));
            notificationManager.sendNotification(new Notification("email", "Ваша учетная запись успешно активирована"));
//            notificationManager.sendNotification(new Notification("sms", "Тестирование фильтра уведомлений на количество символов в смс!"));
            notificationManager.sendNotification(new Notification("sms", "успешно"));
            notificationManager.sendNotification(new Notification("push", "Push notification must be capitalized"));

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
