package faang.school.godbless.MetaVerse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Send by email" + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Send by SMS" + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Send by push" + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification googleNotification = new Notification("google", "Интересненько");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(googleNotification);
    }
}
