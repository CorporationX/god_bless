package meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> sendingHandlers = new HashMap<>();
    private final Map<String, Predicate<Notification>> filteringHandlers = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> correctingHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        if (!sendingHandlers.containsKey(type)) {
            sendingHandlers.put(type, consumer);
        }
    }

    public void registerFilter(String type, Predicate<Notification> predicate) {
        if (!filteringHandlers.containsKey(type)) {
            filteringHandlers.put(type, predicate);
        }
    }

    public void registerCorrectingHandler(String correctionType, Function<Notification, Notification> correctionFunc) {
        if (!correctingHandlers.containsKey(correctionType)) {
            correctingHandlers.put(correctionType, correctionFunc);
        }
    }

    public boolean filterNotification(String filterType, Notification notification) {
        if (filteringHandlers.containsKey(filterType)) {
            return filteringHandlers.get(filterType).test(notification);
        }
        throw new NoSuchElementException("Нет фильтра с таким типом");
    }

    public Notification correctNotification(String correctionType, Notification notification) {
        if (correctingHandlers.containsKey(correctionType)) {
            return correctingHandlers.get(correctionType).apply(notification);
        }
        throw new NoSuchElementException("Нет корректора с таким типом");
    }

    public void sendNotification(Notification notification) {
        if (sendingHandlers.containsKey(notification.getType())) {
            sendingHandlers.get(notification.getType()).accept(notification);
        } else {
            throw new NoSuchElementException("Нет обработчика отправки с таким типом");
        }
    }
}
