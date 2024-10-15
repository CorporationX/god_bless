package school.faang.sprint2.metauniverse;

import java.util.function.Predicate;

@FunctionalInterface
public interface NotificationFilter extends Predicate<Notification> {
    boolean test(Notification notification);
}
