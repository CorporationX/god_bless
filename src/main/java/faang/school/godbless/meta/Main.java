package faang.school.godbless.meta;

public class Main {
    public static void main(String... args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Sending SMS: " + notification.getMessage()));
        notificationManager.registerHandler("email", (notification) -> System.out.println("Sending Email: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Sending PUSH-notification: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(pushNotification);

    }
}
