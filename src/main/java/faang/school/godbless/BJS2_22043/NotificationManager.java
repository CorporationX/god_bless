package faang.school.godbless.BJS2_22043;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private Map<String, Predicate<Notification>> contentFilters = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> message){
        handlers.put(type, message);
    }

    public void sendNotification(Notification notification){
        if (!handlers.values().isEmpty()){
            if (!filterNotification(notification)) {
                handlers.get(notification.getType()).accept(notification);
            }
        }
    }

    public void registerContentFilter(String type, Predicate<Notification> filter) {
        contentFilters.put(type, filter);
    }

    public boolean filterNotification(Notification notification) {
        for (Predicate<Notification> filter : contentFilters.values()) {
            if (filter.test(notification)) {
                return true;
            }
        }
        return false;
    }

}
