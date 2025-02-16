package school.faang.meta_universe;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notificationBase;
    private Predicate<Notification> containsFilterWords;
    private Function<Notification, Notification> addSign;

    public NotificationManager() {
        this.notificationBase = new HashMap<>();
    }

    public void removeNotificationHandler(NotificationType type) {
        notificationBase.remove(type);
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null) {
            throw new IllegalArgumentException("No type or handler given");
        }
        notificationBase.put(type, handler);
    }

    public void setFilterWords(List<String> filterWords) {
        if (filterWords == null) {
            throw new IllegalArgumentException("No filterWords given");
        }

        Predicate<Notification> filterPredicate = note ->
                filterWords.stream().anyMatch(s -> note.getMessage().contains(s));
        containsFilterWords = filterPredicate;
    }

    public void sendNotification(Notification notification) {
        notificationBase.getOrDefault(notification.getType(),
                notificationDefault -> System.out.println(String.format(
                        "Notification handler not found for type: %s", notification.getType()))).accept(notification);
    }

    public void sendFilteredNotification(Notification notification) {
        if (containsFilterWords.test(notification)) {
            System.out.println("Message could not be send because of censorship!");
            return;
        }
        notificationBase.get(notification.getType()).accept(notification);
    }

    public void sendSignedNotification(String sign, Notification notification) {
        addSign = note -> {
            note.setMessage(MessageFormat.format("{0} Company: {1}", note.getMessage(), sign));
            return note;
        };

        System.out.println(addSign.apply(notification).getMessage());
    }
}
