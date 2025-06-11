package school.faang.bjs2_80655;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.printf("email: %s%n", notification.getMessage()));
        manager.registerHandler(NotificationType.SMS, notification ->
                System.out.printf("сбер: %s%n", notification.getMessage()));
        manager.registerHandler(NotificationType.PUSH, notification ->
                System.out.printf("даркнет: %s%n", notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "доступ к email получен");
        Notification smsNotification = new Notification(NotificationType.SMS, "ваш счет успешно заблокирован");
        Notification pushNotification = new Notification(NotificationType.PUSH, "я вам черканул чекните");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);

    }
}