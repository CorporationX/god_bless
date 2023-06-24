package sprint3.lambda.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        init(manager);

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
    }

    private static void init(NotificationManager manager) {
        manager.registerHandler("email", (notification) ->
                System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        manager.registerHandler("sms", (notification) ->
                System.out.println("Отправка SMS: " + notification.getMessage()));
        manager.registerHandler("push", (notification) ->
                System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        manager.registerNotificationLengthChecks("sms", notification ->
                notification.getMessage().length() <= 150);
        manager.registerNotificationLengthChecks("push", notification ->
                notification.getMessage().length() <= 50);
    }

}
