package functions.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        String skype = "skype";
        String telegram = "telegram";
        manager.registerHandler(skype, (notification) -> System.out.println("Отправка по скайпу: " + notification.getMessage()));
        manager.registerHandler(telegram, (notification) -> System.out.println("Отправка по телеграмму: " + notification.getMessage()));

        Notification skypeNotification = new Notification(skype, "Ваша учетная запись успешно активирована");
        Notification telegramNotification = new Notification(telegram, "Вы успешно изменили свой пароль");

        manager.sendNotification(skypeNotification, (id) -> id.getType().equals("skype"));
        manager.sendNotification(telegramNotification, (id) -> id.getType().equals("skype"));
        manager.sendNotification(telegramNotification, (id) -> id.getType().equals("telegram"));
    }
}
