package faang.school.godbless.meta_universe;

public class Test {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", notification -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        notificationManager.registerHandler("discord", notification -> System.out.println("Отправка сообщения в Discord:" + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification discordNotification = new Notification("discord", "Новое сообщение в Discord");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(discordNotification);
    }
}
