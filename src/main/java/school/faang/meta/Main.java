package school.faang.meta;

import java.util.Map;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Map<String, Consumer<Notification>> notificationConsumers = notificationManager.getNotificationConsumers();

        notificationManager.registerHandler("email", notification -> System.out.println(notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println(notification.getMessage()));
        notificationManager.registerHandler("missed call", notification -> System.out.println(notification.getMessage()));

        notificationManager.sendNotification(new Notification("email", "You have a new email"));
        notificationManager.sendNotification(new Notification("sms", "You have a new sms"));
        notificationManager.sendNotification(new Notification("missed call", "You have a missed call"));

        for(Map.Entry<String, Consumer<Notification>> entry: notificationConsumers.entrySet()){
            System.out.println("Notification: " + entry.getKey() + ", Action: " + entry.getValue());
        }

    }
}
