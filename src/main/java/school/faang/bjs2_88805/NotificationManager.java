package school.faang.bjs2_88805;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> handlerMap = new HashMap<>();
    private final Map<NotificationType, Predicate<Notification>> banWordsPredicate = new HashMap<>();
    protected final Set<String> banWords = new HashSet<>();

    protected void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlerMap.put(type, handler);
    }

    protected void sendNotification(Notification notification, Function<Notification, Notification> corrector) {
        Predicate<Notification> filter = banWordsPredicate.get(notification.getType());
        if (filter != null && filter.test(notification)) {
            System.out.println("Вы написали плохое слово!" + notification.getMessage());
            return;
        }
        Consumer<Notification> notificationConsumer = handlerMap.get(notification.getType());
        if (notificationConsumer != null) {
            notificationConsumer.accept(corrector.apply(notification));
        }
    }

    protected void registerPredicateFilter(NotificationType type, String word, Predicate<Notification> filter) {
        banWords.add(word);
        banWordsPredicate.put(type, filter);
    }

}
