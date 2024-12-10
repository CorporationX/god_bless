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

            notificationManager.sendNotification(new Notification("email", "Ваша учетная запись успешно активирована"));
            notificationManager.sendNotification(new Notification("sms", "Вы успешно изменили свой пароль"));
            notificationManager.sendNotification(new Notification("push", "Новый пост от пользователя: JohnDoe"));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
