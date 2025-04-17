package school.faang.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filterList = new ArrayList<>();
    private Function<Notification, Notification> header;
    private final List<String> errors = new ArrayList<>();

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

//    public Notification registerHeader(String header) {
//        Function<Notification, Notification> addHeader = notification -> {
//            notification.setMessage(notification.getMessage() + "\n" + header + "\n");
//            return notification;
//        };
//        return null;
//    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = this.handlers.get(notification.getType());
        if (handler == null) {
            throw new IllegalArgumentException("Обработчик не зарегистрирован");
        }
        handler.accept(notification);
    }

//    public void checkMessage(Notification notification) {
//        Predicate<Notification> filter = notice -> notice.getMessage().contains("брань");
//        if (filter.test(notification)) {
//            throw new IllegalArgumentException("Сообщение заблокировано, не прошло цензуру");
//        }
//    }
//
//    public void addHeader(Function<Notification, Notification> corrector, Notification notification) {
//        corrector.apply(notification);
//    }
}
