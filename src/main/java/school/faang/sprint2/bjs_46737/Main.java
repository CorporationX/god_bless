package school.faang.sprint2.bjs_46737;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: "
                        + notification.message()));
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: "
                        + notification.message()));
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: "
                        + notification.message()));
        notificationManager.registerHandler("", null);

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification notRegisteredNotification = new Notification("voice", "Позвони");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(notRegisteredNotification);
    }
}
