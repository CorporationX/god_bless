package faang.school.godbless.BJS2_22043;


public class Main {

    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification -> System.out.println("Отправка по электронной почте: " + notification.getMessage())));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerContentFilter("спам", notification -> notification.getMessage().contains("спам"));

        notificationManager.sendNotification(new Notification("email", "Ваша учетная запись успешно активирована"));
        notificationManager.sendNotification(new Notification("sms", "Это спам"));
    }

}
