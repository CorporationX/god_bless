package faang.school.godbless.BJS2_22024;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationHandler = new HashMap<>();
    private Map<Predicate<String>, Function<String, String>> filterHandler = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        notificationHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notificationHandler.containsKey(notification.getType())) {
            notificationHandler.get(notification.getType()).accept(notification);
        }
    }

    public void registerFilterHandler(Predicate<String> filter, Function<String, String> correctiveContent) {
        filterHandler.put(filter, correctiveContent);
    }

    public void checkAndCorrectContent(String content) {
        String contentLowerCase = content.toLowerCase();
        for (var filter : filterHandler.entrySet()) {
            if (filter.getKey().test(contentLowerCase)) {
                System.out.println("Inappropriate content detected in '" + content + "'");
                String correctedContent = filter.getValue().apply(content);
                System.out.println("Corrected content: " + correctedContent);
            }
        }
    }
}
