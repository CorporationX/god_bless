package faang.school.godbless.BJS2_21999;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> notifications;
    private final Map<String, Function<Notification, Notification>> filters;

    public NotificationManager() {
        this.notifications = new HashMap<>();
        this.filters = new HashMap<>();
    }

    public void registerHandler(String type, Consumer<Notification> notification){
        if (notifications.containsKey(type)){
            throw new IllegalArgumentException("Notification is already added");
        }
        notifications.put(type, notification);
    }

    public void filterHandler(String type, Function<Notification, Notification> filter){
        if (filters.containsKey(type)){
            throw new IllegalArgumentException("Filter is already added");
        }
        filters.put(type, filter);
    }

    public void sendNotification(Notification notificationToSend){
        Function<Notification, Notification> filter = filters.get(notificationToSend.getType());
        if (filter != null){
            notificationToSend = filter.apply(notificationToSend);
        }

        Consumer<Notification> notification = notifications.get(notificationToSend.getType());
        if (notification != null){
            notification.accept(notificationToSend);
        }else{
            throw new NoSuchElementException("This notification not found!");
        }
    }
}
