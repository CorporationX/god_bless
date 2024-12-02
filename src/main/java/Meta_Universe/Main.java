package Meta_Universe;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Notification notification1 = new Notification("Email", "Отправка по электронной почте");
        Notification notification2 = new Notification("sms", "Отправка SMS");
        Notification notification3 = new Notification("push", "Отправка push-уведомления");


// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println(notification1.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println(notification2.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println(notification3.getMessage()));

// Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
