package school.faang.sprint_2.task_46975;

import java.util.function.Predicate;

public class ContentFilter {
    public static boolean isContentAcceptable(Notification notification, Predicate<String> filter) {
        return filter.test(notification.message());
    }
}
