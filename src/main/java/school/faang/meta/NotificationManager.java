package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notifications;
    private Map<String, Predicate<Notification>> censures;
    private Map<String, Function<Notification, Notification>> correctors;

    public NotificationManager() {
        this.notifications = new HashMap<>();
        this.censures = new HashMap<>();
        this.correctors = new HashMap<>();
    }

    public void registerHandler(String name, Consumer<Notification> consumer) {
        notifications.put(name, consumer);
    }

    public void addCensure(String name, Predicate<Notification> predicate) {
        censures.put(name, predicate);
    }

    public void removeCensure(String name) {
        censures.remove(name);
    }

    public void addCorrector(String name, Function<Notification, Notification> corrector) {
        correctors.put(name, corrector);
    }

    public void removeCorrector(String name) {
        correctors.remove(name);
    }

    public void sendNotification(Notification notification) {
        if (isValidMessage(notification)) {
            correctors.forEach((name, f) -> f.apply(notification));
            notifications.getOrDefault(notification.getType(),
                    (notificationDefault) -> System.out.println("Отправка данным типом не возможна: " + notificationDefault.getType())
            ).accept(notification);
        } else {
            System.out.println("Отправка данного сообщения не возможна. Цензура не пройдена.");
        }
    }

    private boolean isValidMessage(Notification notification) {
        return censures.values()
                .stream()
                .noneMatch(filter -> filter.test(notification));
    }
}
