package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        // Регистрация обработчиков
        manager.registerHandler("email", notification1 -> System.out.println("Email notification: " + notification1.getMessage()));
        manager.registerHandler("sms", notification1 -> System.out.println("SMS notification: " + notification1.getMessage()));
        manager.registerHandler("facebook", notification1 -> System.out.println("Facebook notification: " + notification1.getMessage()));

        Notification emailNotification = new Notification( "email", "Ваша учетная запись успешна активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("facebook", "Новый пост от пользователя: JohnDoe");


        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
    }
}