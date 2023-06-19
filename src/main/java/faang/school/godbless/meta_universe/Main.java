package faang.school.godbless.meta_universe;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        manager.registerHandler("email", notification -> System.out.println("Отправка по электронной почте: " + notification.message()));
        manager.registerHandler("sms", notification -> System.out.println("Отправка SMS: " + notification.message()));
        manager.registerHandler("push", notification -> System.out.println("Отправка push-уведомления: " + notification.message()));

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
    }
}
