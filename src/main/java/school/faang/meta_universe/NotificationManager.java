package school.faang.meta_universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notificationBase;
    private final List<Predicate<Notification>> listNotificationFilters;
    private Predicate<String> containsFilterWords;

    public NotificationManager() {
        this.notificationBase = new HashMap<>();
        this.listNotificationFilters = new ArrayList<>();
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || notificationBase == null) {
            throw new IllegalArgumentException("No type or handler given");
        }

        notificationBase.put(type, handler);
    }

    public void setFilterWords(List<String> filterWords) {
        containsFilterWords = message -> filterWords.stream().anyMatch(s -> message.contains(s));
    }

    public void sendNotification(Notification notification) {

        notificationBase.get(notification.getType()).accept(notification);
    }

    public void sendFilteredNotification(Notification notification) {

        if (containsFilterWords.test(notification.getMessage())) {
            System.out.println("Message could not be send");
            return;
        }

        notificationBase.get(notification.getType()).accept(notification);
    }

    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL, notification -> {
            System.out.println("Email: " + notification.getMessage());
        });
        notificationManager.registerHandler(NotificationType.SMS, notification -> {
            System.out.println("Sms: " + notification.getMessage());
        });
        notificationManager.registerHandler(NotificationType.PUSH, notification -> {
            System.out.println("Push: " + notification.getMessage());
        });

        var listNotifications = List.of(new Notification(NotificationType.EMAIL, "Email received: Hello, Universe!"),
                new Notification(NotificationType.SMS, "Sms received: Hello, Universe!"),
                new Notification(NotificationType.PUSH, "Push received: Hello, Universe!"));

        listNotifications.forEach(notificationManager::sendNotification);

        notificationManager.setFilterWords(List.of("Sms", "Email"));

        System.out.println("*******************************");
        listNotifications.forEach(notificationManager::sendFilteredNotification);
    }
}
