package faang.school.godbless.sprint.two.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> registeredNotifications = new HashMap<>();
    private final Map<String, Function<String, Boolean>> notificationFilters = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        this.registeredNotifications.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        if (this.registeredNotifications.containsKey(notification.getType())) {
            if (notificationFilters.get(Constants.CHECK_BAD_WORDS).apply(notification.getMessage())) {
                System.out.println("Your message contains inappropriate content");
                return;
            }
            this.registeredNotifications.get(notification.getType()).accept(notification);
            return;
        }
        System.out.println("Cannot find notification type: " + notification.getType());
    }

    public void registeredFilters(String name, Function<String, Boolean> isValidString) {
        this.notificationFilters.put(name, isValidString);
    }

}
