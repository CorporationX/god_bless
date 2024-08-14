package faang.school.godbless.BJS221969;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EnhancedNotificationManager extends NotificationManager {
    private List<Predicate<Notification>> filters = new ArrayList<>();
    private List<Function<Notification, Notification>> modifiers = new ArrayList<>();

    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }

    public void addModifier(Function<Notification, Notification> modifier) {
        modifiers.add(modifier);
    }

    @Override
    public void sendNotification(Notification notification) {
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                System.out.println(notification.toString() + " was blocked by the filter");
                return;
            }
        }

        for (Function<Notification, Notification> modifier : modifiers) {
            notification = modifier.apply(notification);
        }

        super.sendNotification(notification);
    }
}
