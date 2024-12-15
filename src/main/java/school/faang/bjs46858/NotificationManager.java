package school.faang.bjs46858;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    Map<String, Consumer<Notification>> notifications = new HashMap<>();
    Set<Predicate<Notification>> validations = new HashSet<>();

    public void registerHandler(String type, Consumer<Notification> action) {
        notifications.put(type, action);
    }

    public void addValidation(Predicate<Notification> validation) {
        validations.add(validation);
    }

    public void sendNotification(Notification notification) {
        boolean valid = validations.stream()
                .allMatch(predicate -> predicate.test(notification));

        if (!valid) {
            throw new IllegalArgumentException("Notification is not valid!");
        }

        var action = notifications.get(notification.getType());
        action.accept(notification);
    }
}
