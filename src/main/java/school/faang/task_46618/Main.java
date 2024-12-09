package school.faang.task_46618;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("telegram", (notification)
                -> System.out.println("Отправка" + notification.getMessage()));
        Notification telegramNotification = new Notification("telegram", "Ваша учетная запись успешно активирована");
        notificationManager.sendNotification(telegramNotification);
    }
}

