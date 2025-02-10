package school.faang.meta_universe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notificationBase;
    private Predicate<Notification> containsFilterWords;
    private Function<Notification, Notification> addSign; // Добавить подпись компании к каждому сообщению

    public NotificationManager() {
        this.notificationBase = new HashMap<>();
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || notificationBase == null) {
            throw new IllegalArgumentException("No type or handler given");
        }

        notificationBase.put(type, handler);
    }

    public void setFilterWords(List<String> filterWords) {
        if (filterWords == null) {
            throw new IllegalArgumentException("No filterWords given");
        }

        containsFilterWords = note ->
                filterWords.stream().anyMatch(s -> note.getMessage().contains(s));
    }

    public void sendNotification(Notification notification) {

        notificationBase.get(notification.getType()).accept(notification);
    }

    public void sendFilteredNotification(Notification notification) {

        if (containsFilterWords.test(notification)) {
            System.out.println("Message could not be send");
            return;
        }

        notificationBase.get(notification.getType()).accept(notification);
    }

    public void sendSignedNotification(String sign, Notification notification) {

        addSign = note -> {
            note.setMessage(new StringBuilder(note.getMessage()).append(" Company: ").append(sign).toString());
            return note;
        };

        System.out.println(addSign.apply(notification).getMessage());
    }
}
