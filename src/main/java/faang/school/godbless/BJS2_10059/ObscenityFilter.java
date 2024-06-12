package faang.school.godbless.BJS2_10059;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ObscenityFilter {

    Map<String, Consumer<Notification>> notifications = new HashMap<>();

    void registerFilter(String id, Consumer<Notification> filter) {
        notifications.put(id, filter);
    }

    void applyFilter(Notification notification) {
        Consumer<Notification> filter = notifications.get(notification.getType());
        filter.accept(notification);
    }
}
