package BJS2_10010;

public class Main {
    public static void main(String[] args) {
        FilterManager manager = new FilterManager();

    // Регистрация обработчиков оповещений
        manager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        manager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        manager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        manager.registerHandler("spam", notification -> System.out.println("Перемещение в спам: " + notification.getMessage()));

    // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification spamNotification = new Notification("sms", "Lets to LoL AYAYADJ");

        manager.addFilter((notification -> notification.getMessage().contains("AYAYADJ")));

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
        manager.sendNotification(spamNotification);
    }
}