package faang.school.godbless.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private static final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();
    private static final List<Predicate<Notification>> filters = new ArrayList<>();

    public static void registerHandler(String notificationType, Consumer<Notification> handler) {
        notificationHandlers.put( notificationType, handler );
    }

    public static void sendNotification(Notification notification) {
        boolean filtered = filters.stream().anyMatch( filter -> filter.test( notification ) );
        if (!filtered) {
            String type = notification.getType();
            Consumer<Notification> handler = notificationHandlers.get( type );
            if (handler != null) {
                handler.accept( notification );
            } else {
                System.out.println( "No handler registered for notification type: " + type );
            }
        } else {
            System.out.println( notification.getMessage() + " - Notification is not sent because contains banned word" );
        }

    }

    public static void registerFilter(Predicate<Notification> filter) {
        filters.add( filter );
    }
}