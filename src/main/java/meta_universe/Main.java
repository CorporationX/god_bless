package meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Map<String, Consumer<Notification>> handlers = new HashMap<>();

        NotificationManager notificationManager = new NotificationManager(handlers);
        notificationManager.registerHandler("sms", notification -> {
            System.out.println(notification.getMessage());
        });
        notificationManager.registerHandler("email", notification -> {
            System.out.println(notification.getMessage());
        });

        notificationManager.sendNotification(new Notification("sms", "SMS: Hello"));
        notificationManager.sendNotification(new Notification("email", "EMAIL: Dear user"));
    }
}
