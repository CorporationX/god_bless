package school.faang.universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationMap = new HashMap<>();
    private final Map<String, Function<String, String>> substitutionMap = new HashMap<>();

    public void addFilterSubstitution(String source, Function<String, String> action) {
        substitutionMap.computeIfAbsent(source, k -> action);
    }

    public void registerHandler(String id, Consumer<Notification> action) {
        notificationMap.computeIfAbsent(id, k -> action);
    }

    public Optional<Boolean> sendNotification(Notification notification) {
        Consumer<Notification> action = notificationMap.get(notification.getType());
        if (action != null) {
            Notification result = analyze(notification);
            action.accept(result);
            return Optional.of(true);
        }
        return Optional.empty();
    }

    private Notification analyze(Notification notification) {
        String message = notification.getMessage();
        if (message == null) {
            return notification;
        }

        String[] splited = message.split(" ");
        List<Function<String, String>> substitutionActions = new ArrayList<>();

        for (String s : splited) {
            var action = substitutionMap.get(s.toLowerCase());
            if (action != null) {
                substitutionActions.add(action);
            }
        }

        for (Function<String, String> substitutionAction : substitutionActions) {
            message = substitutionAction.apply(message);
        }

        return new Notification(notification.getType(), message);
    }
}
