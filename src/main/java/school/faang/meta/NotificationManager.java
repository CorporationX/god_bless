package school.faang.meta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> mapHandler = new HashMap<>();
    private static final Function<Notification, Notification> addMessage = notification ->
            new Notification(notification.type(), notification.message() + " @BadCompany prodaction");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type != null) {
            mapHandler.put(type, handler);
        } else {
            throw new NullPointerException();
        }
    }

    public void sendNotification(Notification notification) {
        boolean correctMessage = isCorrectMessage(massage ->
                Arrays.asList(massage.split(" ")).contains("плохо"), notification.message());
        if (!correctMessage) {
            mapHandler.get(notification.type()).accept(addMessage.apply(notification));
        }
    }

    public boolean isCorrectMessage(Predicate<String> predicate, String message) {
        return predicate.test(message);
    }

}
