package school.faang.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Notification email = new Notification("email", "Hello");
        Notification push = new Notification("youtube", "New video");
        Notification discord = new Notification("discord", "Save discord!");
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("New message on email: " + notification.getMessage()));
        notificationManager.registerHandler("youtube",
                notification -> System.out.println("Youtube: " + notification.getMessage()));
        notificationManager.registerHandler("discord",
                (notification) -> System.out.println("What's new: " + notification.getMessage()));
        notificationManager.sendNotification(email);
        notificationManager.sendNotification(push);
        notificationManager.sendNotification(discord);
    }
}
