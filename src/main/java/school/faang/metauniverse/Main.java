package school.faang.metauniverse;

public class Main {

    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Sending Email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Sending PUSH: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("Sending SMS: " + notification.getMessage()));

        notificationManager.setCorrector(notification -> {
            notification.setMessage(notification.getMessage() + "\nCorporationX");
            return notification;
        });

        String word = "дурак";
        notificationManager.addFilters(notification -> notification.getMessage().contains(word));
        notificationManager.addFilters(notification -> notification.getMessage().isBlank());

        notificationManager.sendNotification(new Notification(NotificationType.EMAIL, "Hello!"));
        notificationManager.sendNotification(new Notification(NotificationType.SMS, "Cheers!"));
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, "Sup, дурак"));
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, "  "));
    }
}
