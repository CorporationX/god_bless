package school.faang.meta_verse_bjs2_80609;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        String forbiddenWord = "нельзя";

        notificationManager.addFilter(NotificationType.SMS, notification -> {
            String message = notification.getMessage().toLowerCase();
            return !message.contains(forbiddenWord);
        });

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("PUSH: " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль нельзя изменить");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Нельзя пропускать такую выгоду!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
