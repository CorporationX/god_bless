package school.faang.bjs270636;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(Notification.NotificationType.EMAIL, notification -> {
            System.out.println("Отправлен EMAIL: " + notification.getMessage());
        });
        manager.registerHandler(Notification.NotificationType.PUSH, notification -> {
            System.out.println("Отправлен PUSH: " + notification.getMessage());
        });
        manager.registerHandler(Notification.NotificationType.SMS, notification -> {
            System.out.println("Отправлено SMS: " + notification.getMessage());
        });

        Notification emailNotification = new Notification(
                Notification.NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(
                Notification.NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(
                Notification.NotificationType.PUSH, "У вас новое сообщение!");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);

        Predicate<Notification> lengthFilter = notification ->
                notification.getMessage().length() > 35;
        manager.sendNotificationWithFilter(emailNotification, lengthFilter);
    }
}
