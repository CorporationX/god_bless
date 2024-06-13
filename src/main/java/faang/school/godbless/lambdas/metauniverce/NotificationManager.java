package faang.school.godbless.lambdas.metauniverce;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlerByType = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> censorByType = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        if (type == null || consumer == null) {
            throw new IllegalArgumentException();
        }

        handlerByType.put(type, consumer);
    }

    public void registerCensor(String type, Function<Notification, Notification> censor) {
        if (type == null || censor == null) {
            throw new IllegalArgumentException();
        }

        censorByType.put(type, censor);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException();
        }

        Function<Notification, Notification> censor = censorByType.get(notification.getType());
        if (censor != null) {
            censor.apply(notification);
        } else {
            System.out.printf("Debug: цензор для типа %s не зарегистрирован\n", notification.getType());
        }

        Consumer<Notification> handler = handlerByType.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.printf("Debug: обработчик уведомлений для типа %s отсутсвует\n", notification.getType());
        }
    }
}
