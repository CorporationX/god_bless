package school.faang.bjs2_70565;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.registerHandler(NotificationType.EMAIL,
            notification -> System.out.printf("email: %s\n", notification.getMessage()));
        manager.registerHandler(NotificationType.SMS,
            notification -> System.out.printf("sms: %s\n", notification.getMessage()));
        manager.registerHandler(NotificationType.PUSH,
            notification -> System.out.printf("push notification: %s\n", notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        if (manager.censored(emailNotification,
            notification -> !notification.getMessage().contains("нецензурность"))) {
            manager.sendNotification(
                emailNotification, notification -> notification.getMessage() + " (Окончание текста письма)"
            );
        }

        if (manager.censored(smsNotification,
            notification -> !notification.getMessage().contains("нецензурность"))) {
            manager.sendNotification(smsNotification,
                notification -> notification.getMessage() + " (окончание sms)");
        }

        if (manager.censored(pushNotification,
            notification -> !notification.getMessage().contains("нецензурность"))) {
            manager.sendNotification(pushNotification,
                notification -> notification.getMessage() + " @push message@");
        }
    }
}
