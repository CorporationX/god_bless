package school.faang.bsj2_87711;

public class Main {
    public static void main(String[] args) {
        Notification notificationEmail = new Notification(NotificationType.EMAIL,
                "Вам завещали АВТОМОБИЛЬ!");
        Notification notificationPush = new Notification(NotificationType.PUSH,
                "Погасите кредит!");
        Notification notificationSms = new Notification(NotificationType.SMS,
                "Завтра будет дождь, не забудьте взять зонтик");
        Notification notificationUnknown = new Notification(NotificationType.UNKNOWN,
                "Do anything");

        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Отправка уведомления в приложений: \"" +
                        notification.getMessage() + "\""));
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Отправка сообщения по почте: \"" +
                        notification.getMessage() + "\""));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("Отправка сообщения на номер: \"" +
                        notification.getMessage() + "\""));

        notificationManager.sendNotification(notification ->
                        notification.getMessage().length() <= Notification.MAX_NOTIFICATION_LENGTH,
                        notificationEmail);
        notificationManager.sendNotification(notification ->
                        notification.getMessage().length() <= Notification.MAX_NOTIFICATION_LENGTH,
                        notificationPush);
        notificationManager.sendNotification(notification ->
                        notification.getMessage().length() <= Notification.MAX_NOTIFICATION_LENGTH,
                        notificationSms);
        notificationManager.sendNotification(notification ->
                        notification.getMessage().length() <= Notification.MAX_NOTIFICATION_LENGTH,
                        notificationUnknown);
    }
}
