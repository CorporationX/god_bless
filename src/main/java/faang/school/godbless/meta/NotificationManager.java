package faang.school.godbless.meta;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class NotificationManager {

    private static final Set<String> MODERATION_TRIGGERS = Set.of("buy", "vote", "donate", "bitch", "purchase");
    private final Map<String, BiFunction<Notification, Set<String>, String>> notificationStore = new HashMap<>();

    public void registerHandler(String id, BiFunction<Notification, Set<String>, String> handler) {
        notificationStore.put(id, handler);
    }

    public void sendNotification(Notification notification) {
        String moderatedMsg = notificationStore.get(notification.getType()).apply(notification, detectTriggers(notification));
        System.out.printf("Sending %s --- %s%n", notification.getType(), moderatedMsg);
    }

    private static Set<String> detectTriggers(Notification notification) {
        return Collections.checkedSet(MODERATION_TRIGGERS, String.class)
                .stream()
                .filter(str -> notification.getMessage().contains(str))
                .collect(Collectors.toSet());
    }
}
