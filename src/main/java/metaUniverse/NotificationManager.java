package metaUniverse;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@ToString
@Data
public class NotificationManager {
    public static Map<String, Consumer<Notification>> stringByNotification = new HashMap<>();

    public static void registerHandler(String type, Consumer<Notification> funcInt) {
        if (!stringByNotification.containsKey(type)) {
            stringByNotification.put(type, funcInt);
        } else {
            throw new IllegalArgumentException("Ошибка в registerHandler");
        }

    }

    public static void outputMap() {
        for (Map.Entry<String, Consumer<Notification>> pair : stringByNotification.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
    }

    public static void sendNotification(Notification notification) {
        if (stringByNotification.containsKey(notification.getType())) {
           Consumer<Notification> func = stringByNotification.get(notification.getType());
           func.accept(notification);
        } else {
            throw new IllegalArgumentException("Ошибка в sendNotification");
        }
    }
}
