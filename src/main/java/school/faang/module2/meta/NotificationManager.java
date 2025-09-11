package school.faang.module2.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private static final Set<String> FORBIDDEN_WORDS = Set.of("vpn", "peace", "meta");
    private final Map<NotificationType, Consumer<Notification>> notificationSystem = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationSystem.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (filterNotification(notification, n -> FORBIDDEN_WORDS.stream().anyMatch(n.getMessage()::contains))) {
            System.out.printf("Used forbidden word in message: %s%n", notification.getMessage());
            return;
        }
        Notification signedNotification = addSignToMessage(notification, n -> {
            n.setMessage("%s | Your Meta".formatted(n.getMessage()));
            return n;
        });
        notificationSystem.getOrDefault(notification.getType(),
                n -> System.out.printf("Default Notification: %s%n", notification.getMessage()))
                        .accept(signedNotification);
    }

    private boolean filterNotification(Notification notification, Predicate<Notification> filter) {
        return filter.test(notification);
    }

    private Notification addSignToMessage(Notification notification, Function<Notification, Notification> corrector) {
        return corrector.apply(notification);
    }
}
