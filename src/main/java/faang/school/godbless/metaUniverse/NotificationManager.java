package faang.school.godbless.metaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private Map<String, Consumer<Notification>> map;
    private Map<String, Function<Notification, Integer>> mapOfPriority;

    public NotificationManager() {
        this.map = new HashMap<>();
        this.mapOfPriority = new HashMap<>();
    }

    public void registerHandler(String type, Consumer<Notification> consumer) {
        if (type == null || type.isEmpty() || consumer == null) {
            throw new IllegalArgumentException("Некорректные параметры!");
        }

        map.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Объект Notification равен null!");
        }

        if (!map.containsKey(notification.getType())) {
            throw new IllegalArgumentException("Идентификатор оповещения отсутствует среди заданных!");
        }

        map.get(notification.getType()).accept(notification);
    }

    //Обработчики возвращают приоритет оповещения (например, для дальнейшего упорядоченного по важности отображения)
    public void registerHandlerPriority(String type, Function<Notification, Integer> function) {
        if (type == null || type.isEmpty() || function == null) {
            throw new IllegalArgumentException("Некорректные параметры!");
        }

        mapOfPriority.put(type, function);
    }

    public int sendNotificationPriority(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Объект Notification равен null!");
        }

        if (!mapOfPriority.containsKey(notification.getType())) {
            throw new IllegalArgumentException("Идентификатор оповещения отсутствует среди заданных!");
        }

        return mapOfPriority.get(notification.getType()).apply(notification);
    }
}
