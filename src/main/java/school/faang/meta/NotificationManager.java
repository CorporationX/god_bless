package school.faang.meta;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filterList = new ArrayList<>();
    private Function<Notification, Notification> header;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (this.handlers.containsKey(type)) {
            throw new IllegalArgumentException("Обработчик для данного типа уведомлений уже зарегистрирован");
        }
        this.handlers.put(type, handler);
    }

    public void addFilter(Predicate<Notification> filter) {
        filterList.add(filter);
    }

    public void addHeader(Function<Notification, Notification> header) {
        this.header = header;
    }

    public void sendNotification(Notification notification) {
        if (filterList.stream()
                .anyMatch(filter -> filter.test(notification))) {
            log.error("Сообщение [ {} ] не прошло цензуру", notification.getMessage());
            return;
        }
        this.header.apply(notification);
        Consumer<Notification> handler = this.handlers.get(notification.getType());
        if (handler == null) {
            throw new IllegalArgumentException("Обработчик не зарегистрирован");
        }
        handler.accept(notification);
    }
}