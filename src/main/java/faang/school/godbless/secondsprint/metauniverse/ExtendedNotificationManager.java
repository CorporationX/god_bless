package faang.school.godbless.secondsprint.metauniverse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExtendedNotificationManager extends NotificationManager {
    private static List<Predicate<Notification>> contentFilters = new ArrayList<>();
    private static List<Function<Notification, Notification>> contentModifiers = new ArrayList<>();

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
