public class Application {
    public static void main(String[] args) {
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification contentFilterNotification = new Notification("filter", "неприемлемый контент");

        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("email", notification ->
                                    System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification ->
                                    System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification ->
                                    System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        notificationManager.registerHandler("filter", notification ->
                                    System.out.println("Найти видео MORGENSTERN: " + notification.getMessage()));


        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(contentFilterNotification);
    }
}
