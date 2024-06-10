package faang.school.godbless.module1.sprint2.task3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class NotificationManager {
    private static Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public static void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type,handler);
    }

    public static void spam(Notification notification) {
        Predicate<String> predicate = s -> s.contains("http");
        if (!predicate.test(notification.getMassage())) {
            sendNotification(notification);
        } else {
            notification.setMassage("spam");
            sendNotification(notification);
        }
    }

    private static void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler found for notification type: " + notification.getType());
        }
    }



}


