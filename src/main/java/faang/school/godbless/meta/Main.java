package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = getNotificationManager();

        manager.sendNotification(new Notification("EMAIL", "New email received"));
        manager.sendNotification(new Notification("SMS", "Reminder: Meeting at 3 PM"));
        manager.sendNotification(new Notification("PUSH", "You have a new message"));
        manager.sendNotification(new Notification("CALL", "Incoming call"));
    }

    private static NotificationManager getNotificationManager() {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler("EMAIL", notification -> {
            System.out.println("Sending email: " + notification.getMessage());
        });

        manager.registerHandler("SMS", notification -> {
            System.out.println("Sending SMS: " + notification.getMessage());
        });

        manager.registerHandler("PUSH", notification -> {
            System.out.println("Sending push notification: " + notification.getMessage());
        });
        return manager;
    }
}
