public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = getNotificationManager();

        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification emailNotification = new Notification("email", "Новый пост от пользователя: JohnDoe");
        Notification callNotification = new Notification("call", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(callNotification);
    }

    private static NotificationManager getNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        return notificationManager;
    }
}
