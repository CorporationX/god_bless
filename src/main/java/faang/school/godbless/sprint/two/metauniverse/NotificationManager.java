package faang.school.godbless.sprint.two.metauniverse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> registeredNotifications = new HashMap<>();
    private final Map<Function<String, Boolean>, List<String>> notificationFilters = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        this.registeredNotifications.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        if (this.registeredNotifications.containsKey(notification.getType())) {

            boolean isInappropriateContent = notificationFilters.entrySet().stream()
                    .anyMatch(entry -> entry.getValue().contains(notification.getType())
                            && entry.getKey().apply(notification.getMessage()));

            if (isInappropriateContent) {
                System.out.println("Your message contains inappropriate content");
                return;
            }

            this.registeredNotifications.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Cannot find notification type: " + notification.getType());
        }

    }

    public void registeredFilters(Function<String, Boolean> isValidString, List<String> notifications) {
        this.notificationFilters.put(isValidString, notifications);
    }

}
