package school.faang.meta;

public class Realisation {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push: " + notification.getMessage())
        );

        notificationManager.setFilter(n -> !n.getMessage().toLowerCase().contains("запрещено"));

        notificationManager.setCorrector(n -> new Notification(n.getType(), n.getMessage() + "\n\n— Компания Meta"));

        Notification goodEmail = new Notification(NotificationType.EMAIL, "Добро пожаловать!");
        Notification badSms = new Notification(NotificationType.SMS, "Это запрещено!");

        notificationManager.sendNotification(goodEmail);
        notificationManager.sendNotification(badSms);
    }
}
