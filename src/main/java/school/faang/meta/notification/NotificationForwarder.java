package school.faang.meta.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class NotificationForwarder {
    private final List<Function<Notification, Optional<NotificationType>>> forwardRules = new ArrayList<>();

    public void addForwardRule(Function<Notification, Optional<NotificationType>> forwardRule) {
        forwardRules.add(forwardRule);
    }

    public Notification applyForwardRules(Notification notification) {
        Notification current = notification;
        for (Function<Notification, Optional<NotificationType>> forwarder : forwardRules) {
            Optional<NotificationType> newType = forwarder.apply(current);
            if (newType.isPresent()) {
                current = new Notification(newType.get(), current.getMessage());
            }
        }
        return current;
    }
}
