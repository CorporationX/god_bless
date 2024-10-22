package school.faang.metaWorld;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("sms",
                notification -> System.out.println(notification.getMessage()));

        notificationManager.registerHandler("email",
                notification -> System.out.println(notification.getMessage()));

        notificationManager.registerHandler("phone",
                notification -> System.out.println(notification.getMessage()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
