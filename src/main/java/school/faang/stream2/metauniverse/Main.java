package school.faang.stream2.metauniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification myNotification = new Notification(NotificationType.SMS, "У вас будет сова!");
        Notification owlNotification = new Notification(NotificationType.OWL, "У вас сова, угу!");
        Notification rudeNotification = new Notification(NotificationType.SMS, "Ты чё бля долбоёб охуел?!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(myNotification);
        notificationManager.sendNotification(rudeNotification);
        notificationManager.sendNotification(owlNotification);
    }
}
