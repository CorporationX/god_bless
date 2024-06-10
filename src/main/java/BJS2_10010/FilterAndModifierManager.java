package BJS2_10010;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterAndModifierManager extends NotificationManager {
    List<Predicate<Notification>> filters = new ArrayList<>();

    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }


    @Override
    public void sendNotification(Notification notification) {
        for (Predicate<Notification> filter : filters) {
            if (filter.test(notification)) {
                notification.setType("spam");
                System.out.format("Filtered notification: %s", notification.getMessage());
                return;
            }
        }
        super.sendNotification(notification);
    }
}
