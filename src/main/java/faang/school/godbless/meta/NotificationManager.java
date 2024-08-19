package faang.school.godbless.meta;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class NotificationManager {
    private static final Set<String> MODERATION_TRIGGERS = Set.of("buy", "vote", "donate", "witch", "purchase");
    private final Map<String, BiFunction<Notification, Set<String>, String>> notificationStore = new HashMap<>();

    public void registerHandler(String type, BiFunction<Notification, Set<String>, String> handler) {
        notificationStore.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        BiFunction<Notification, Set<String>, String> handler = notificationStore.get(notification.getType());
        String message = handler.apply(notification, detectTriggers(notification));
        System.out.printf("Sending %s --- %s%n", notification.getType(), message);
    }

    private static Set<String> detectTriggers(Notification notification) {
        return Collections.checkedSet(MODERATION_TRIGGERS, String.class)
                .stream()
                .filter(str -> notification.getMessage().contains(str))
                .collect(Collectors.toSet());
    }
}
