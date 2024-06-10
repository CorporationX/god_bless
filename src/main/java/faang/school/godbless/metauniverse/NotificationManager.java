package faang.school.godbless.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<String, Predicate<Notification>> contentFilters = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> contentCorrectors = new HashMap<>();

    public NotificationManager() {
        contentFilters.put("push", notification -> !notification.getMessage().contains("плохое слово"));
        contentFilters.put("email", notification -> !notification.getMessage().contains("плохое слово"));
        contentFilters.put("sms", notification -> !notification.getMessage().contains("плохое слово"));

        contentCorrectors.put("push", notification -> {
            String correctedMessage = notification.getMessage().replace("плохое слово", "хорошее слово");
            return new Notification(notification.getType(), correctedMessage);
        });
        contentCorrectors.put("email", notification -> {
            String correctedMessage = notification.getMessage().replace("плохое слово", "хорошее слово");
            return new Notification(notification.getType(), correctedMessage);
        });
        contentCorrectors.put("sms", notification -> {
            String correctedMessage = notification.getMessage().replace("плохое слово", "хорошее слово");
            return new Notification(notification.getType(), correctedMessage);
        });
    }

    public void registerHandler(String notificationId, Consumer<Notification> handler) {
        handlers.put(notificationId, handler);
    }

    public void sendNotification(Notification notification) {
        String notificationId = notification.getType();
        Predicate<Notification> filter = contentFilters.getOrDefault(notificationId, contentFilters.getOrDefault("all", n -> true));
        Function<Notification, Notification> corrector = contentCorrectors.getOrDefault(notificationId, contentCorrectors.getOrDefault("all", Function.identity()));

        if (!filter.test(notification)) {
            notification = corrector.apply(notification);
        }

        Consumer<Notification> handler = handlers.get(notificationId);
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Handler not found for notification type: " + notificationId);
        }
    }
}
