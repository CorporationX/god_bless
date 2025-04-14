package school.faang.meta.notification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class NotificationEditor {
    private final Map<NotificationType, List<Function<Notification, Notification>>> editRules =
            new EnumMap<>(NotificationType.class);

    public void addEditRule(NotificationType type, Function<Notification, Notification> editRule) {
        this.editRules.computeIfAbsent(type, k -> new ArrayList<>()).add(editRule);
    }

    public Notification applyEditRules(Notification notification) {
        return this.editRules.getOrDefault(notification.getType(), Collections.emptyList())
                .stream()
                .reduce(Function.identity(), Function::andThen)
                .apply(notification);
    }
}
