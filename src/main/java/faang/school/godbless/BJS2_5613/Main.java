package faang.school.godbless.BJS2_5613;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(
                "email", notification -> System.out.println("Отправка через email: " + notification.getMessage())
        );
        notificationManager.registerHandler(
                "sms", notification -> System.out.println("Отправка по SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler(
                "push", notification -> System.out.println("Отправка push уведомлений: " + notification.getMessage())
        );

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
