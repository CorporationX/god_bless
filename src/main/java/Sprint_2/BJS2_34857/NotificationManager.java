package Sprint_2.BJS2_34857;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет зарегистрированного обработчика для типа: " + notification.getType());
        }
    }

    public void registerFilteredHandler(String type, Predicate<Notification> filter, Function<Notification, Notification> corrector) {
        handlers.put(type, notification -> {
            if (!filter.test(notification)) {
                System.out.println("Сообщение не прошло фильтр, корректируем...");
                notification = corrector.apply(notification);
            }
            System.out.println("Обработано сообщение: " + notification);
        });
    }
}

