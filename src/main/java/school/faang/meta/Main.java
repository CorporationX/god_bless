package school.faang.meta;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", notification -> System.out.println(notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println(notification.getMessage()));
        notificationManager.registerHandler("missed call", notification -> System.out.println(notification.getMessage()));

        System.out.println(NotificationManager.notificationConsumer);

        notificationManager.sendNotification(new Notification("email", "You have a new email"));
        notificationManager.sendNotification(new Notification("sms", "You have a new sms"));
        notificationManager.sendNotification(new Notification("missed call", "You have a missed call"));

    }
}
