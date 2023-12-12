package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private static Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public static void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        notifications.put(type, notificationConsumer);
    }

    public static void sendNotification(Notification notification) {
        Consumer<Notification> consumer = notifications.get(notification.getType());
        consumer.accept(notification);
    }

    public static void main(String[] args) {

        Notification emailNotification = new Notification("email", "new email!");
        Notification messageNotification = new Notification("message", "new message!");

        registerHandler("email", (notification) ->
                System.out.println("you have received a " + notification.getMessage()));
        registerHandler("message", (notification) ->
                System.out.println("you have received a " + notification.getMessage()));
        sendNotification(emailNotification);
        sendNotification(messageNotification);
    }
}
