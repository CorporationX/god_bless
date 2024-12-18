package school.faang.task_46917;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHander("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));

        notificationManager.registerHander("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));

        notificationManager.registerHander("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));


        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification spamNotification = new Notification("spam", "Новый курс по успешному успеху");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(spamNotification);

    }
}
