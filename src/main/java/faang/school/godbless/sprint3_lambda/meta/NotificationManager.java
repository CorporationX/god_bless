package faang.school.godbless.sprint3_lambda.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();
    List<Predicate<Notification>> list = new ArrayList<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type is null or empty");
        }
        map.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = map.get(notification.getType());
        if (handler == null) {
            throw new IllegalArgumentException();
        }
        handler.accept(notification);
    }

    void fillList(Predicate<Notification> nn) {
        list.add(nn);
    }

    public boolean filter(Notification notification) {
        for (Predicate<Notification> loopi : list) {
            if (!loopi.test(notification)) {
                return false;
            }
        }
        return true;
    }
}
