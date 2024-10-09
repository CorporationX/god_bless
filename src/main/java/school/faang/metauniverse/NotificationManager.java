package school.faang.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationProcessor = new HashMap<>();
    private final Map<String, Predicate<String>> notificationSpamFilter = new HashMap<>();
    private final Map<String, Function<String, String>> notificationMessageProcessor = new HashMap<>();

    public void registerHandler(String notificationIdentifier, Consumer<Notification> notificationConsumer) {
        notificationProcessor.put(notificationIdentifier, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        notificationProcessor.get(notification.type()).accept(notification);
    }

    public void registerSpamFilter(String notificationIdentifier, Predicate<String> notificationFilter) {
        notificationSpamFilter.put(notificationIdentifier, notificationFilter);
    }

    public void filterNotification(Notification notification) {
        boolean containsSpam = notificationSpamFilter.get(notification.type()).test(notification.message());
        if (!containsSpam) {
            System.out.println("SPAM CHECK PASS :) Message type: " + notification.type() + "; Message:\"" + notification.message() + "\"");
        } else {
            System.out.println("SPAM DETECTED! Message type: " + notification.type() + "; Message:\"" + notification.message() + "\"");
        }
    }

    public void registerMessageProcessor(String notificationType, Function<String, String> messageProcessor) {
        notificationMessageProcessor.put(notificationType, messageProcessor);
    }

    public void processMessage(Notification notification) {
        String updatedMessage = notificationMessageProcessor.get(notification.type()).apply(notification.message());
        System.out.println(updatedMessage);
    }
}
