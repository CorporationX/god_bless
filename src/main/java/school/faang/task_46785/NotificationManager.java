package school.faang.task_46785;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> consumerMap = new HashMap<>();

    public void registerHandler(String notification, Consumer<Notification> consumer) {
        consumerMap.put(notification, consumer);
    }

    public void sendNotification(Notification notification, Function<Notification, Notification> modifier) {
        Notification modifierNotification = modifier.apply(notification);

        Consumer<Notification> consumer = consumerMap.get(modifierNotification.getType());
        if (consumer != null) {
            consumer.accept(modifierNotification);
        } else {
            System.out.println("Нет обработчика для типа оповещения: " + modifierNotification.getType());
        }
    }
}
