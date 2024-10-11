package metauniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("ds",
                notification -> System.out.println("отправлено сообщение в ds: " + notification.getMessage()));
        notificationManager.registerHandler("tg",
                notification -> System.out.println("отправлено сообщение в tg: " + notification.getMessage()));
        notificationManager.registerHandler("vk",
                notification -> System.out.println("сообщение отправлено в vk: " + notification.getMessage()));

        Notification dsNotification = new Notification("ds", "вы добавлены на сервер");
        Notification tgNotification = new Notification("tg", "вы добавлены в канал");
        Notification vkNotification = new Notification("vk", "вы добавлены в группу");
        Notification vk2Notification = new Notification("vk2", "вы добавлены в группу");

    }
}
