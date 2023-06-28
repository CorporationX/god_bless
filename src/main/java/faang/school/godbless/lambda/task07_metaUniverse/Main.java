package faang.school.godbless.lambda.task07_metaUniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notif) -> System.out.println("Отправка по электронной почте: " + notif.getMessage()));
        notificationManager.registerHandler("sms", (notif) -> System.out.println("Отправка SMS: " + notif.getMessage()));
        notificationManager.registerHandler("push", (notif) -> System.out.println("Отправка push-уведомления: " + notif.getMessage()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
