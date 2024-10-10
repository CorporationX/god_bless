package school.faang.meta;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private static final String DEFAULT_MESSAGE = "Отправка данным типом не возможна: ";
    private static final String CENSORED_MESSAGE = "Отправка данного сообщения не возможна. Цензура не пройдена.";

    @Getter
    private List<String> sentMessages = new ArrayList<>();
    private Map<String, Consumer<Notification>> notifications = new HashMap<>();
    private Map<String, Predicate<Notification>> censures = new HashMap<>();
    private Map<String, Function<Notification, Notification>> correctors = new HashMap<>();

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
            for (Function<Notification, Notification> corrector : correctors.values()) {
                notification = corrector.apply(notification);
            }
            Consumer<Notification> notificationAction = notifications.get(notification.getType());
            if (notificationAction != null) {
                notificationAction.accept(notification);
            } else {
                String defaultMessage = DEFAULT_MESSAGE + notification.getType();
                sentMessages.add(defaultMessage);
                System.out.println(defaultMessage);
            }
        } else {
            sentMessages.add(CENSORED_MESSAGE);
            System.out.println(CENSORED_MESSAGE);
        }
    }

    private boolean isValidMessage(Notification notification) {
        return censures.values()
                .stream()
                .noneMatch(filter -> filter.test(notification));
    }
}
