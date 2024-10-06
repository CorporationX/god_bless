package school.BJS2_34611;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private Map<String, Consumer<Notification>> listeners = new HashMap<>();

    private Map<Set<String>, Predicate<Notification>> listenersWithPredicate = new HashMap<>();

    public void registerHandler2(Set<String> set, Predicate<Notification> predicate) {
        listenersWithPredicate.put(set,predicate);
    }

    public void registerHandler(String type, Consumer<Notification> handler) {
        listeners.put(type, handler);
    }

    public void sendNotification(Set<String> set, Notification notification) {
        String type = notification.getType();
        if (!listenersWithPredicate.get(set).test(notification)) {
            listeners.get(type).accept(notification);
        } else {
            System.out.printf("Отправка %s заблокировна, есть контент 18+", type);
            System.out.println();
        }
    }


}
