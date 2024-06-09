package faang.school.godbless.meta_universe;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<String, Consumer<Notification>> managerFunctions;
    private final List<Notification> notifications;

    public NotificationManager() {
        this.managerFunctions = new HashMap<>();
        this.notifications = new ArrayList<>();
    }

    void registerHandler(String identifier, Consumer<Notification> notificationAction) {
        managerFunctions.put(identifier, notificationAction);
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    void sendNotification(Notification notification) {
        if (managerFunctions.containsKey(notification.getType())) {
            managerFunctions.get(notification.getType()).accept(notification);
        } else {
            log.warn("Notification Manager does not have such functions");
        }
    }

    public void showFilteredNotifications(Predicate<Notification> filter) {
        for (Notification notification : notifications) {
            if (filter.test(notification)) {
                System.out.println("Notification type: " + notification.getType());
                System.out.println("Notification message: " + notification.getMessage());
                System.out.println();
            }
        }
    }

    public String filterMessageOfNotification(Notification notification, Function<String, String> messageHandler) {
        return messageHandler.apply(notification.getMessage());
    }
}
