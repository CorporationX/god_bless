package MetaUniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка на email: " + notification.getMessage()));
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push уведомления: " + notification.getMessage()));

        Notification smsNotification = new Notification("sms", "Ваш пароль успешно изменен.");
        Notification emailNotification = new Notification("email", "Ваша учетная запись активирована.");
        Notification pushNotification = new Notification("push", "Новое видео на канале Vlad Mishustin.");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
