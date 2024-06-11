package faang.school.godbless.BJS2_10075;
/*
Создайте класс NotificationManager с методами: registerHandler:
принимает идентификатор оповещения и функциональный интерфейс (например, Consumer<Notification>), добавляет пару ключ-значение в Map;

sendNotification: принимает объект типа Notification и вызывает соответствующий обработчик оповещения из Map.

Создайте несколько обработчиков оповещений, используя лямбда-выражения и стандартные функциональные интерфейсы Java;

Подумайте, как ещё вы могли бы расширить эту систему, с помощью других коллекций обработчиков с дополнительными функциональными интерфейсами.
 Возможно, вы могли бы создать Map из фильтров содержания нотификаций, чтобы обнаруживать неприемлемый контент.
 А, возможно, даже обработчики, затем корректирующие этот контент с помощью Function…
 В Meta от вас ждут инициативности и находчивости в разработке собственных креативных решений.
  Этот пункт мы оставили специально свободным для вас, чтобы вы могли воплощать свои идеи!
 */

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> consumer) {
        if (id != null || consumer != null) {
            notificationMap.put(id, consumer);
        }
    }

    public void sendNotification(Notification notification) {
        if (notification != null) {
            Consumer<Notification> handler = notificationMap.get(notification.getType());

            if (handler != null) {
                handler.accept(notification);
            }
        }
    }
}
