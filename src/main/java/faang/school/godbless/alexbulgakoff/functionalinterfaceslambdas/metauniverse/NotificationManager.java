package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.metauniverse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author Alexander Bulgakov
 */

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandler;

    private List<String> blackList;

    public NotificationManager() {
        notificationHandler = new HashMap<>();
        blackList = Arrays.asList("Fuck", "Fuck you", "Shit", "Douchebag", "fuck", "fuck you", "shit", "douchebag");
    }

    public void registerHandler(String identifier, Consumer<Notification> consumer) {
        notificationHandler.put(identifier, consumer);
    }

    public void sendNotification(Notification notification) {
        if (filterBlackList(notification)) {
            notification.setMessage("The text contains inappropriate words");
        }
        notificationHandler.get(notification.getType()).accept(notification);
    }

    private boolean filterBlackList(Notification notification) {
        return blackList.stream().anyMatch(word -> notification.getMessage().contains(word));
    }
}
