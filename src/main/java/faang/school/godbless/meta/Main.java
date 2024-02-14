package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.registerHandler("email", notification -> System.out.println("Email send: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println("Sms send: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification -> System.out.println("Push send: " + notification.getMessage()));

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
