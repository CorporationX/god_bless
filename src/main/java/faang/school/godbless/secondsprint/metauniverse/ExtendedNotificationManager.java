package faang.school.godbless.secondsprint.metauniverse;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExtendedNotificationManager extends NotificationManager {
    private List<Predicate<Notification>> contentFilters;
    private List<Function<Notification, Notification>> contentModifiers;

    public ExtendedNotificationManager(List<Predicate<Notification>> contentFilters,
                                       List<Function<Notification, Notification>> contentModifiers) {
        this.contentFilters = contentFilters;
        this.contentModifiers = contentModifiers;
    }

    public void registerFilter(Predicate<Notification> filter) {
        contentFilters.add(filter);
    }

    public void registerModifier(Function<Notification, Notification> modifier) {
        contentModifiers.add(modifier);
    }

    @Override
    public void sendNotification(Notification notification) {
        Notification finalNotification = notification;
        boolean isBlocked = contentFilters.stream()
                .anyMatch(filter -> !filter.test(finalNotification));

        if (isBlocked) {
            System.out.println(notification.toString() + " - was blocked.");
            return;
        }

        for (Function<Notification, Notification> modifier : contentModifiers) {
            notification = modifier.apply(notification);
        }

        super.sendNotification(notification);
    }
}
