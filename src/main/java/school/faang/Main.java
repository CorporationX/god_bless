package school.faang;

public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        try {
            new User("Oleg", 35, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("", 35, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("Oleg", 17, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("Oleg", 35, "VK", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("Oleg", 35, "Amazon", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
    }
}
