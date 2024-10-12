package school.faang.BJS2_34774;

import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

@Setter
public class NotificationManager {

    private Set<String> filterSet = new HashSet<>();
    private Map<Set<String>, Function<Notification, Notification>> filterMap = new HashMap<>();
    private Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void registerFilter(Set<String> filterSet, Function<Notification, Notification> filterMethod) {
        filterMap.put(filterSet,filterMethod);
    }

    public void sendWithFilter(Notification notification) {
        for(Map.Entry<Set<String>, Function<Notification, Notification>> entry : filterMap.entrySet()) {
            entry.getValue().apply(notification);
        }
        sendNotification(notification);
    }

    public void sendWithFilter1(Notification notification, Function<Notification, Notification> filter ){
        sendNotification(filter.apply(notification));
    }

    public void sendNotification(Notification notification){
        Consumer<Notification> consumer = notifications.get(notification.getType());
        consumer.accept(notification);
    }
}
