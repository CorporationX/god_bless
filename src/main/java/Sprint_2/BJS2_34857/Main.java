package Sprint_2.BJS2_34857;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("Info", notification -> System.out.println("processing info: " + notification.getMessage()));

        notificationManager.registerHandler("Warning", notification -> System.out.println("processing warning: " + notification.getMessage()));

        notificationManager.registerHandler("Error", notification -> System.out.println("processing warning: " + notification.getMessage()));


        Notification infoNotification = new Notification("Info", "This is an info message.");
        Notification warningNotification = new Notification("Warning", "This is an warning message.");
        Notification errorNotification = new Notification("Error", "This is an error message.");


        notificationManager.sendNotification(infoNotification);
        notificationManager.sendNotification(warningNotification);
        notificationManager.sendNotification(errorNotification);


        Predicate<Notification> containsBadWord = notification -> !notification.getMessage().toLowerCase().contains("bad");
        Function<Notification, Notification> correctMessage = notification -> {
            notification.setMessage(notification.getMessage().replace("bad", "[censored]"));
            return notification;
        };

        notificationManager.registerFilteredHandler("FILTERED", containsBadWord, correctMessage);

        Notification filteredNotification = new Notification("FILTERED", "This is a bad message.");
        notificationManager.sendNotification(filteredNotification);
    }
}


