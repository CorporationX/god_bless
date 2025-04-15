package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (this.handlers.containsKey(type)) {
            throw new IllegalArgumentException("Обработчик для данного типа уведомлений уже зарегистрирован");
        }
        this.handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = this.handlers.get(notification.getType());
        if (handler == null) {
            throw new IllegalArgumentException("Обработчик не зарегистрирован");
        }
        handler.accept(notification);
    }

    public void checkMessage(Notification notification) {
        Predicate<Notification> filter = notice -> notice.getMessage().contains("брань");
        if (filter.test(notification)) {
            throw new IllegalArgumentException("Сообщение заблокировано, не прошло цензуру");
        }
    }

    public void addHeader(Function<Notification, Notification> corrector, Notification notification ) {
        corrector.apply(notification);
    }

//    public void addHeader(Notification notification) {
//        Function<Notification, Notification> corrector = notice -> {
//            notice.setMessage(notification.getMessage() + "\nC Уважением, Meta\n");
//            return notice;
//        };
//        corrector.apply(notification);
//    }
}
