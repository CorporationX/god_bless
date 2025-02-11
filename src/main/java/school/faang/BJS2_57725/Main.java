package school.faang.BJS2_57725;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(NotificationType.EMAIL, notif ->
                System.out.println("Отправка уведомления по электронной почте: " + notif.getMessage()));

        manager.registerHandler(NotificationType.SMS, notif ->
                System.out.println("Отправка уведомления по смс: " + notif.getMessage()));

        manager.registerHandler(NotificationType.PUSH, notif ->
                System.out.println("Отправка PUSH-уведомления: " + notif.getMessage()));

        manager.sendNotification(new Notification(NotificationType.EMAIL, "У вас новое сообщение!"));
        manager.sendNotification(new Notification(NotificationType.SMS, "Ваш код — 1234."));
        manager.sendNotification(new Notification(NotificationType.PUSH, "Доступно новое обновление!"));
    }
}
