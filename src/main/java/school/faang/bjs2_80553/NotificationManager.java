package school.faang.bjs2_80553;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Data
@Slf4j
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlerMap = new HashMap<>();
    private List<Predicate<Notification>> filterList = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlerMap.put(type, handler);
    }

    public void registerFilter(Predicate<Notification> filter) {
        filterList.add(filter);
    }

    public void sendNotification(Notification notification) {
        if (!filterList.stream().allMatch(filter -> filter.test(notification))) {
            Consumer<Notification> handler = handlerMap.get(notification.getType());
            if (handler != null) {
                handler.accept(notification);
            } else {
                log.info("{} could not be processed", notification.getType());
            }
        } else {
            log.info(notification.getType() + ": Notification blocked due to profanity");
        }
    }
}

