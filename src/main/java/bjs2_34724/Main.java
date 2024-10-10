package bjs2_34724;

public class Main {
    public static void main(String[] args) {
        NotificationManager nm = new NotificationManager();
        nm.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        nm.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        nm.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        nm.sendNotification(emailNotification);
        nm.sendNotification(smsNotification);
        nm.sendNotification(pushNotification);
    }
}
