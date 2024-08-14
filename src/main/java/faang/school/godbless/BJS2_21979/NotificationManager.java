package faang.school.godbless.BJS2_21979;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private Map<String, Consumer<Notification>> listeners = new HashMap<>();
    private List<Predicate<String[]>> validators = new ArrayList<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        listeners.put(type, handler);
    }

    public void registerValidator(Predicate<String[]> validator) {
        validators.add(validator);
    }

    public void sendNotificationIfValid(Notification notification) {
        String[] words = notification.getMessage().split(" ");
        if (!isValidMessage(words)) {
            return;
        }

        Consumer<Notification> handler = listeners.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler registered for " + notification.getType());
        }
    }

    private boolean isValidMessage(String[] words) {
        for (Predicate<String[]> validator : validators) {
            if (!validator.test(words)) {
                return false;
            }
        }
        return true;
    }
}
