package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.metauniverse;

/**
 * @author Alexander Bulgakov
 */

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = getNotificationManager();


        Notification notificationComments =
                new Notification("new comment", "You have new comments");
        Notification notificationReminders =
                new Notification("reminders", "You event will start in one day");
        Notification notificationRequests =
                new Notification("requests", "You have 3 new friend requests");
        Notification notificationMessages =
                new Notification("messages", "You have a new message");

        Notification shitWords = new Notification("shit comment", "Fuck you douchebag");


        notificationManager.sendNotification(notificationComments);
        notificationManager.sendNotification(notificationReminders);
        notificationManager.sendNotification(notificationRequests);
        notificationManager.sendNotification(notificationMessages);

        notificationManager.sendNotification(shitWords);
    }

    private static NotificationManager getNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("new comment",
                (notification) -> System.out.println("New comment received: " + notification.getMessage()));
        notificationManager.registerHandler("reminders",
                (notification) -> System.out.println("Expected event: " + notification.getMessage()));
        notificationManager.registerHandler("requests",
                (notification) -> System.out.println("New friend request: " + notification.getMessage()));
        notificationManager.registerHandler("messages",
                (notification) -> System.out.println("New message: " + notification.getMessage()));
        notificationManager.registerHandler("shit comment",
                (notification) -> System.out.println("shit comment: " + notification.getMessage()));
        return notificationManager;
    }
}
