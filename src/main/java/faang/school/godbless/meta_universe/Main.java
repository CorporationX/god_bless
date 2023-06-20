package faang.school.godbless.meta_universe;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        notificationManager.addFilter(notification -> notification.getMessage().contains("X"));
        notificationManager.addFilter(notification -> notification.getMessage().contains("Y"));

        notificationManager.editNotification(NotificationType.EMAIL, message -> "contains X: " + message);
        notificationManager.editNotification(NotificationType.PUSH, message -> "contains Y: " + message);

        Notification emailNotification = new Notification(
                NotificationType.EMAIL, "XВаша учетная запись успешно активирована");
        Notification smsNotification = new Notification(
                NotificationType.SMS, "Вы успешно изменили свой парольY");
        Notification pushNotification = new Notification(
                NotificationType.PUSH, "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
