package school.faang.bjs246755;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {

        Optional.ofNullable(type)
                .filter(t -> !t.isEmpty())
                .flatMap(t -> Optional.ofNullable(consumer))
                .ifPresent(c -> {
                    notifications.put(type, c);
                    log.info("The type '{}' have put", type);
                });
    }

    public void sendNotification(Notification notification) {
        Optional.ofNullable(notifications.get(notification.getType()))
                .ifPresent(typeNotification -> typeNotification.accept(notification));
        log.info("the notification have sent");
    }
}